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
package com.arcadedb.schema;

import com.arcadedb.database.DatabaseInternal;
import com.arcadedb.index.Index;
import com.arcadedb.index.lsm.LSMTreeIndexAbstract;

/**
 * Builder class for index types.
 *
 * @author Luca Garulli (l.garulli@arcadedata.com)
 */
public abstract class IndexBuilder<T extends Index> {
  final DatabaseInternal       database;
  final Class<? extends Index> indexMode;
  Schema.INDEX_TYPE                  indexType;
  boolean                            unique;
  int                                pageSize       = LSMTreeIndexAbstract.DEF_PAGE_SIZE;
  LSMTreeIndexAbstract.NULL_STRATEGY nullStrategy   = LSMTreeIndexAbstract.NULL_STRATEGY.SKIP;
  Index.BuildIndexCallback           callback;
  boolean                            ignoreIfExists = false;

  protected IndexBuilder(final DatabaseInternal database, final Class<? extends Index> indexMode) {
    this.database = database;
    this.indexMode = indexMode;
  }

  public abstract T create();

  public IndexBuilder<T> withType(final Schema.INDEX_TYPE indexType) {
    this.indexType = indexType;
    return this;
  }

  public IndexBuilder<T> withUnique(final boolean unique) {
    this.unique = unique;
    return this;
  }

  public IndexBuilder<T> withIgnoreIfExists(final boolean ignoreIfExists) {
    this.ignoreIfExists = ignoreIfExists;
    return this;
  }

  public IndexBuilder<T> withPageSize(final int pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  public IndexBuilder<T> withNullStrategy(final LSMTreeIndexAbstract.NULL_STRATEGY nullStrategy) {
    this.nullStrategy = nullStrategy;
    return this;
  }

  public IndexBuilder<T> withCallback(final Index.BuildIndexCallback callback) {
    this.callback = callback;
    return this;
  }
}
