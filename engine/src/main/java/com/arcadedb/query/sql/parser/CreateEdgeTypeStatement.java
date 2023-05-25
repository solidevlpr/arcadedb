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
/* Generated By:JJTree: Do not edit this line. OCreateClassStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_USERTYPE_VISIBILITY_PUBLIC=true */
package com.arcadedb.query.sql.parser;

import com.arcadedb.schema.DocumentType;
import com.arcadedb.schema.EdgeType;
import com.arcadedb.schema.Schema;

public class CreateEdgeTypeStatement extends CreateTypeAbstractStatement {
  public CreateEdgeTypeStatement(final int id) {
    super(id);
  }

  @Override
  public String commandType() {
    return "create edge type";
  }

  @Override
  protected DocumentType createType(final Schema schema) {
    final EdgeType type;
    if (totalBucketNo != null)
      type = schema.buildEdgeType().withName(name.getStringValue()).withTotalBuckets(totalBucketNo.getValue().intValue()).create();
    else {
      if (buckets == null || buckets.isEmpty())
        type = schema.createEdgeType(name.getStringValue());
      else {
        // CHECK THE BUCKETS FIRST
        type = schema.buildEdgeType().withName(name.getStringValue()).withBuckets(getBuckets(schema)).create();
      }
    }
    return type;
  }

  @Override
  public CreateEdgeTypeStatement copy() {
    return (CreateEdgeTypeStatement) super.copy(new CreateEdgeTypeStatement(-1));
  }
}
/* JavaCC - OriginalChecksum=4043013624f55fdf0ea8fee6d4f211b0 (do not edit this line) */
