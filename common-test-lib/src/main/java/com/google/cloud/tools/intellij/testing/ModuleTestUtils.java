/*
 * Copyright 2018 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.tools.intellij.testing;

import com.intellij.facet.FacetManager;
import com.intellij.facet.FacetType;
import com.intellij.facet.FacetTypeId;
import com.intellij.facet.FacetTypeRegistry;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;

/** Test utilities for working with {@link Module}. */
public class ModuleTestUtils {

  public static void addFacet(Module module, FacetTypeId<?> facetTypeId) {
    FacetType<?, ?> facetType = FacetTypeRegistry.getInstance().findFacetType(facetTypeId);

    ApplicationManager.getApplication()
        .invokeAndWait(
            () ->
                ApplicationManager.getApplication()
                    .runWriteAction(
                        () -> {
                          FacetManager.getInstance(module)
                              .addFacet(facetType, facetTypeId.toString(), null /*underlying*/);
                        }));
  }
}
