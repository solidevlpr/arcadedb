/*
 * Copyright © 2021-present Arcade Data Ltd (info@arcadedata.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-FileCopyrightText: 2021-present Arcade Data Ltd (info@arcadedata.com)
 * SPDX-License-Identifier: Apache-2.0
 */
/* Generated By:JJTree: Do not edit this line. OMatchStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_USERTYPE_VISIBILITY_PUBLIC=true */
package com.arcadedb.query.sql.parser;

import com.arcadedb.database.Database;
import com.arcadedb.database.DatabaseInternal;
import com.arcadedb.database.Identifiable;
import com.arcadedb.database.Record;
import com.arcadedb.exception.CommandExecutionException;
import com.arcadedb.query.sql.executor.BasicCommandContext;
import com.arcadedb.query.sql.executor.CommandContext;
import com.arcadedb.query.sql.executor.InternalExecutionPlan;
import com.arcadedb.query.sql.executor.MatchExecutionPlanner;
import com.arcadedb.query.sql.executor.PatternEdge;
import com.arcadedb.query.sql.executor.ResultSet;
import com.arcadedb.schema.DocumentType;
import com.arcadedb.schema.Schema;

import java.util.*;
import java.util.stream.*;

import static com.arcadedb.query.sql.parser.SqlParserTreeConstants.JJTLIMIT;
import static com.arcadedb.query.sql.parser.SqlParserTreeConstants.JJTTIMEOUT;

public class MatchStatement extends Statement {

  static final        String                 DEFAULT_ALIAS_PREFIX    = "$ARCADEDB_DEFAULT_ALIAS_";
  public static final String                 KEYWORD_MATCH           = "MATCH";
  // parsed data
  protected           List<MatchExpression>  matchExpressions        = new ArrayList<>();
  protected           List<MatchExpression>  notMatchExpressions     = new ArrayList<>();
  protected           List<Expression>       returnItems             = new ArrayList<>();
  protected           List<Identifier>       returnAliases           = new ArrayList<>();
  protected           List<NestedProjection> returnNestedProjections = new ArrayList<>();
  protected           boolean                returnDistinct          = false;
  protected           GroupBy                groupBy;
  protected           OrderBy                orderBy;
  protected           Unwind                 unwind;
  protected           Skip                   skip;
  // post-parsing generated data
  protected           Pattern                pattern;
  //  private Map<String, WhereClause> aliasFilters;
//  private Map<String, String>      aliasUserTypes;
  // execution data
  private             CommandContext         context;
  //  private OProgressListener progressListener;
  private             Database               database;

  public List<NestedProjection> getReturnNestedProjections() {
    return returnNestedProjections;
  }

  public void setReturnNestedProjections(final List<NestedProjection> returnNestedProjections) {
    this.returnNestedProjections = returnNestedProjections;
  }

  public static class MatchContext {
    int currentEdgeNumber = 0;

    final Map<String, Iterable>     candidates   = new LinkedHashMap<String, Iterable>();
    final Map<String, Identifiable> matched      = new LinkedHashMap<String, Identifiable>();
    final Map<PatternEdge, Boolean> matchedEdges = new IdentityHashMap<PatternEdge, Boolean>();

    public MatchContext copy(final String alias, final Identifiable value) {
      final MatchContext result = new MatchContext();

      result.candidates.putAll(candidates);
      result.candidates.remove(alias);

      result.matched.putAll(matched);
      result.matched.put(alias, value);

      result.matchedEdges.putAll(matchedEdges);
      result.currentEdgeNumber = currentEdgeNumber;
      return result;
    }

    public Record toDoc() {
      throw new UnsupportedOperationException();
    }

  }

  public static class EdgeTraversal {
    boolean out = true;
    final PatternEdge edge;

    public EdgeTraversal(final PatternEdge edge, final boolean out) {
      this.edge = edge;
      this.out = out;
    }
  }

  public static class MatchExecutionPlan {
//    public List<EdgeTraversal> sortedEdges;
//    public Map<String, Long>   preFetchedAliases = new HashMap<String, Long>();
//    public String              rootAlias;
  }

  public MatchStatement() {
    super(-1);
  }

  public MatchStatement(final int id) {
    super(id);
  }

  @Override
  public ResultSet execute(final Database db, final Object[] args, final CommandContext parentcontext, final boolean usePlanCache) {
    this.database = db;
    final BasicCommandContext context = new BasicCommandContext();
    if (parentcontext != null) {
      context.setParentWithoutOverridingChild(parentcontext);
    }
    context.setDatabase(db);
    context.setInputParameters(args);

    setProfilingConstraints((DatabaseInternal) database);

    final InternalExecutionPlan executionPlan = createExecutionPlan(context, false);

    return new LocalResultSet(executionPlan);
  }

  @Override
  public ResultSet execute(final Database db, final Map params, final CommandContext parentcontext, final boolean usePlanCache) {
    this.database = db;
    final BasicCommandContext context = new BasicCommandContext();
    if (parentcontext != null) {
      context.setParentWithoutOverridingChild(parentcontext);
    }
    context.setDatabase(db);

    setProfilingConstraints((DatabaseInternal) database);

    context.setInputParameters(params);
    final InternalExecutionPlan executionPlan = createExecutionPlan(context, false);

    return new LocalResultSet(executionPlan);
  }

  public InternalExecutionPlan createExecutionPlan(final CommandContext context, final boolean enableProfiling) {
    final MatchExecutionPlanner planner = new MatchExecutionPlanner(this);
    return planner.createExecutionPlan(context, enableProfiling);
  }

  protected void buildPatterns() {
    assignDefaultAliases(this.matchExpressions);
    pattern = new Pattern();
    for (final MatchExpression expr : this.matchExpressions) {
      pattern.addExpression(expr);
    }

    final Map<String, WhereClause> aliasFilters = new LinkedHashMap<String, WhereClause>();
    final Map<String, String> aliasUserTypes = new LinkedHashMap<String, String>();
    for (final MatchExpression expr : this.matchExpressions) {
      addAliases(database, expr, aliasFilters, aliasUserTypes, context);
    }

//    this.aliasFilters = aliasFilters;
//    this.aliasUserTypes = aliasUserTypes;

    rebindFilters(aliasFilters);
  }

  /**
   * rebinds filter (where) conditions to alias nodes after optimization
   *
   * @param aliasFilters
   */
  private void rebindFilters(final Map<String, WhereClause> aliasFilters) {
    for (final MatchExpression expression : matchExpressions) {
      WhereClause newFilter = aliasFilters.get(expression.origin.getAlias());
      expression.origin.setFilter(newFilter);

      for (final MatchPathItem item : expression.items) {
        newFilter = aliasFilters.get(item.filter.getAlias());
        item.filter.setFilter(newFilter);
      }
    }
  }

  /**
   * assigns default aliases to pattern nodes that do not have an explicit alias
   *
   * @param matchExpressions
   */
  private void assignDefaultAliases(final List<MatchExpression> matchExpressions) {
    int counter = 0;
    for (final MatchExpression expression : matchExpressions) {
      if (expression.origin.getAlias() == null) {
        expression.origin.setAlias(DEFAULT_ALIAS_PREFIX + (counter++));
      }

      for (final MatchPathItem item : expression.items) {
        if (item.filter == null) {
          item.filter = new MatchFilter(-1);
        }
        if (item.filter.getAlias() == null) {
          item.filter.setAlias(DEFAULT_ALIAS_PREFIX + (counter++));
        }
      }
    }
  }

  public boolean returnsPathElements() {
    for (final Expression item : returnItems) {
      if (item.toString().equalsIgnoreCase("$pathElements")) {
        return true;
      }
    }
    return false;
  }

  public boolean returnsElements() {
    for (final Expression item : returnItems) {
      if (item.toString().equalsIgnoreCase("$elements")) {
        return true;
      }
    }
    return false;
  }

  public boolean returnsPatterns() {
    for (final Expression item : returnItems) {
      if (item.toString().equalsIgnoreCase("$patterns")) {
        return true;
      }
      if (item.toString().equalsIgnoreCase("$matches")) {
        return true;
      }
    }
    return false;
  }

  public boolean returnsPaths() {
    for (final Expression item : returnItems) {
      if (item.toString().equalsIgnoreCase("$paths")) {
        return true;
      }
    }
    return false;
  }

  private void addAliases(final Database database, final MatchExpression expr, final Map<String, WhereClause> aliasFilters,
      final Map<String, String> aliasUserTypes, final CommandContext context) {
    addAliases(database, expr.origin, aliasFilters, aliasUserTypes, context);
    for (final MatchPathItem item : expr.items) {
      if (item.filter != null) {
        addAliases(database, item.filter, aliasFilters, aliasUserTypes, context);
      }
    }
  }

  private void addAliases(final Database database, final MatchFilter matchFilter, final Map<String, WhereClause> aliasFilters,
      final Map<String, String> aliasUserTypes, final CommandContext context) {
    final String alias = matchFilter.getAlias();
    final WhereClause filter = matchFilter.getFilter();
    if (alias != null) {
      if (filter != null && filter.baseExpression != null) {
        WhereClause previousFilter = aliasFilters.get(alias);
        if (previousFilter == null) {
          previousFilter = new WhereClause(-1);
          previousFilter.baseExpression = new AndBlock(-1);
          aliasFilters.put(alias, previousFilter);
        }
        final AndBlock filterBlock = (AndBlock) previousFilter.baseExpression;
        if (filter != null && filter.baseExpression != null) {
          filterBlock.subBlocks.add(filter.baseExpression);
        }
      }

      final String typez = matchFilter.getTypeName(context);
      if (typez != null) {
        final String previousClass = aliasUserTypes.get(alias);
        if (previousClass == null) {
          aliasUserTypes.put(alias, typez);
        } else {
          final String lower = getLowerSubclass(database, typez, previousClass);
          if (lower == null) {
            throw new CommandExecutionException("classes defined for alias " + alias + " (" + typez + ", " + previousClass + ") are not in the same hierarchy");
          }
          aliasUserTypes.put(alias, lower);
        }
      }
    }
  }

  private String getLowerSubclass(final Database database, final String className1, final String className2) {
    final Schema schema = database.getSchema();
    final DocumentType class1 = schema.getType(className1);
    final DocumentType class2 = schema.getType(className2);
    if (class1 == null) {
      throw new CommandExecutionException("Type " + className1 + " not found in the schema");
    }
    if (class2 == null) {
      throw new CommandExecutionException("Type " + className2 + " not found in the schema");
    }
    if (class1.isSubTypeOf(className2)) {
      return class1.getName();
    }
    if (class2.isSubTypeOf(className1)) {
      return class2.getName();
    }
    return null;
  }

  @Override
  public boolean isIdempotent() {
    return true;
  }

  public void toString(final Map<String, Object> params, final StringBuilder builder) {
    builder.append(KEYWORD_MATCH);
    builder.append(" ");
    boolean first = true;
    for (final MatchExpression expr : this.matchExpressions) {
      if (!first) {
        builder.append(", ");
      }
      expr.toString(params, builder);
      first = false;
    }
    builder.append(" RETURN ");
    if (returnDistinct) {
      builder.append("DISTINCT ");
    }
    first = true;
    int i = 0;
    for (final Expression expr : this.returnItems) {
      if (!first) {
        builder.append(", ");
      }
      expr.toString(params, builder);
      if (returnNestedProjections != null && i < returnNestedProjections.size() && returnNestedProjections.get(i) != null) {
        returnNestedProjections.get(i).toString(params, builder);
      }
      if (returnAliases != null && i < returnAliases.size() && returnAliases.get(i) != null) {
        builder.append(" AS ");
        returnAliases.get(i).toString(params, builder);
      }
      i++;
      first = false;
    }
    if (groupBy != null) {
      builder.append(" ");
      groupBy.toString(params, builder);
    }
    if (orderBy != null) {
      builder.append(" ");
      orderBy.toString(params, builder);
    }
    if (unwind != null) {
      builder.append(" ");
      unwind.toString(params, builder);
    }
    if (skip != null) {
      builder.append(" ");
      skip.toString(params, builder);
    }
    if (limit != null) {
      builder.append(" ");
      limit.toString(params, builder);
    }
  }

  @Override
  public MatchStatement copy() {
    final MatchStatement result = new MatchStatement(-1);
    result.database = database;
    result.matchExpressions = matchExpressions == null ? null : matchExpressions.stream().map(x -> x.copy()).collect(Collectors.toList());
    result.notMatchExpressions =
        notMatchExpressions == null ? null : notMatchExpressions.stream().map(x -> x == null ? null : x.copy()).collect(Collectors.toList());
    result.returnItems = returnItems == null ? null : returnItems.stream().map(x -> x.copy()).collect(Collectors.toList());
    result.returnAliases = returnAliases == null ? null : returnAliases.stream().map(x -> x.copy()).collect(Collectors.toList());
    result.returnNestedProjections = returnNestedProjections == null ? null : returnNestedProjections.stream().map(x -> x.copy()).collect(Collectors.toList());
    result.groupBy = groupBy == null ? null : groupBy.copy();
    result.orderBy = orderBy == null ? null : orderBy.copy();
    result.unwind = unwind == null ? null : unwind.copy();
    result.skip = skip == null ? null : skip.copy();
    result.limit = limit == null ? null : limit.copy();
    result.returnDistinct = this.returnDistinct;
    result.buildPatterns();
    return result;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    final MatchStatement that = (MatchStatement) o;

    if (!Objects.equals(matchExpressions, that.matchExpressions))
      return false;
    if (!Objects.equals(notMatchExpressions, that.notMatchExpressions))
      return false;
    if (!Objects.equals(returnItems, that.returnItems))
      return false;
    if (!Objects.equals(returnAliases, that.returnAliases))
      return false;
    if (!Objects.equals(returnNestedProjections, that.returnNestedProjections))
      return false;
    if (!Objects.equals(groupBy, that.groupBy))
      return false;
    if (!Objects.equals(orderBy, that.orderBy))
      return false;
    if (!Objects.equals(unwind, that.unwind))
      return false;
    if (!Objects.equals(skip, that.skip))
      return false;
    if (!Objects.equals(limit, that.limit))
      return false;

    return returnDistinct == that.returnDistinct;
  }

  @Override
  public int hashCode() {
    int result = matchExpressions != null ? matchExpressions.hashCode() : 0;
    result = 31 * result + (notMatchExpressions != null ? notMatchExpressions.hashCode() : 0);
    result = 31 * result + (returnItems != null ? returnItems.hashCode() : 0);
    result = 31 * result + (returnAliases != null ? returnAliases.hashCode() : 0);
    result = 31 * result + (returnNestedProjections != null ? returnNestedProjections.hashCode() : 0);
    result = 31 * result + (groupBy != null ? groupBy.hashCode() : 0);
    result = 31 * result + (orderBy != null ? orderBy.hashCode() : 0);
    result = 31 * result + (unwind != null ? unwind.hashCode() : 0);
    result = 31 * result + (skip != null ? skip.hashCode() : 0);
    result = 31 * result + (limit != null ? limit.hashCode() : 0);
    return result;
  }

  public List<Identifier> getReturnAliases() {
    return returnAliases;
  }

  public void setReturnAliases(final List<Identifier> returnAliases) {
    this.returnAliases = returnAliases;
  }

  public List<Expression> getReturnItems() {
    return returnItems;
  }

  public void setReturnItems(final List<Expression> returnItems) {
    this.returnItems = returnItems;
  }

  public List<MatchExpression> getMatchExpressions() {
    return matchExpressions;
  }

  public void setMatchExpressions(final List<MatchExpression> matchExpressions) {
    this.matchExpressions = matchExpressions;
  }

  public List<MatchExpression> getNotMatchExpressions() {
    return notMatchExpressions;
  }

  public void setNotMatchExpressions(final List<MatchExpression> notMatchExpressions) {
    this.notMatchExpressions = notMatchExpressions;
  }

  public boolean isReturnDistinct() {
    return returnDistinct;
  }

  public void setReturnDistinct(final boolean returnDistinct) {
    this.returnDistinct = returnDistinct;
  }

  public OrderBy getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(final OrderBy orderBy) {
    this.orderBy = orderBy;
  }

  public GroupBy getGroupBy() {
    return groupBy;
  }

  public void setGroupBy(final GroupBy groupBy) {
    this.groupBy = groupBy;
  }

  public Unwind getUnwind() {
    return unwind;
  }

  public void setUnwind(final Unwind unwind) {
    this.unwind = unwind;
  }

  public Skip getSkip() {
    return skip;
  }

  public void setSkip(final Skip skip) {
    this.skip = skip;
  }

  private void setProfilingConstraints(final DatabaseInternal db) {
    final long profiledLimit = db.getResultSetLimit();
    if (profiledLimit > -1 && (limit == null || limit.num.value.longValue() > profiledLimit))
      setLimit(new Limit(JJTLIMIT).setValue((int) profiledLimit));

    final long profiledTimeout = db.getReadTimeout();
    if (profiledTimeout > -1 && (timeout == null || timeout.val.longValue() > profiledTimeout))
      setTimeout(new Timeout(JJTTIMEOUT).setValue((int) profiledTimeout));
  }
}
/* JavaCC - OriginalChecksum=6ff0afbe9d31f08b72159fcf24070c9f (do not edit this line) */
