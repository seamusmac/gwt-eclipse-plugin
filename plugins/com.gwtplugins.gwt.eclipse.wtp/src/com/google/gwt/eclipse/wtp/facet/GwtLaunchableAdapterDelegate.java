/*******************************************************************************
 * Copyright 2013 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.google.gwt.eclipse.wtp.facet;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.wst.server.core.IModuleArtifact;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.model.IURLProvider;
import org.eclipse.wst.server.core.model.LaunchableAdapterDelegate;
import org.eclipse.wst.server.core.util.HttpLaunchable;

import java.net.URL;

public final class GwtLaunchableAdapterDelegate extends LaunchableAdapterDelegate {

  public GwtLaunchableAdapterDelegate() {
  }

  @Override
  public Object getLaunchable(IServer server, IModuleArtifact moduleArtifact) throws CoreException {
    IURLProvider urlProvider = (IURLProvider) server.loadAdapter(IURLProvider.class, null);
    if (urlProvider == null) {
      return null;
    }
    URL url = urlProvider.getModuleRootURL(moduleArtifact.getModule());
    return new HttpLaunchable(url);
  }
}
