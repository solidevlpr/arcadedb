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
package com.arcadedb.integration.importer;

import com.arcadedb.integration.importer.graph.GraphImporter;

import java.util.*;
import java.util.concurrent.atomic.*;

public class ImporterContext {
  public final AtomicLong    parsed                     = new AtomicLong();
  public final AtomicLong    createdDocuments           = new AtomicLong();
  public final AtomicLong    createdVertices            = new AtomicLong();
  public final AtomicLong    createdEdges               = new AtomicLong();
  public final AtomicLong    createdEmbeddedDocuments   = new AtomicLong();
  public final AtomicLong    linkedEdges                = new AtomicLong();
  public final AtomicLong    updatedDocuments           = new AtomicLong();
  public final AtomicLong    documentsWithLinksToUpdate = new AtomicLong();
  public final AtomicLong    skippedEdges               = new AtomicLong();
  public final AtomicLong    errors                     = new AtomicLong();
  public final AtomicLong    warnings                   = new AtomicLong();
  public       GraphImporter graphImporter;
  public       long          startedOn;
  public       long          lastLapOn;
  public       long          lastParsed;
  public       long          lastDocuments;
  public       long          lastVertices;
  public       long          lastEdges;
  public       long          lastLinkedEdges;

  public Map<String, Object> toMap() {
    final LinkedHashMap<String, Object> map = new LinkedHashMap<>();

    if (parsed.get() > 0)
      map.put("parsedRecords", parsed.get());
    if (errors.get() > 0)
      map.put("errors", errors.get());
    if (warnings.get() > 0)
      map.put("warnings", warnings.get());
    if (createdDocuments.get() > 0)
      map.put("createdDocuments", createdDocuments.get());
    if (createdVertices.get() > 0)
      map.put("createdVertices", createdVertices.get());
    if (createdEdges.get() > 0)
      map.put("createdEdges", createdEdges.get());

    return map;
  }
}
