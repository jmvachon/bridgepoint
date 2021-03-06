//========================================================================
//
//File:      $RCSfile: GraphicsZoomComboContributionItem.java,v $
//Version:   $Revision: 1.6 $
//Modified:  $Date: 2013/01/10 23:05:58 $
//
//(c) Copyright 2005-2014 by Mentor Graphics Corp. All rights reserved.
//
//========================================================================
// Licensed under the Apache License, Version 2.0 (the "License"); you may not 
// use this file except in compliance with the License.  You may obtain a copy 
// of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software 
// distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
// WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   See the 
// License for the specific language governing permissions and limitations under
// the License.
//======================================================================== 
//
package org.xtuml.bp.ui.graphics.actions;

import org.eclipse.gef.ui.actions.ZoomComboContributionItem;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IPartService;

public class GraphicsZoomComboContributionItem extends
		ZoomComboContributionItem {

	public GraphicsZoomComboContributionItem(IPartService partService, String[] zoomStrings) {
		super(partService, zoomStrings);
	}

	@Override
	protected Control createControl(Composite parent) {
		Combo combo = (Combo) super.createControl(parent);
		combo.setVisibleItemCount(20);
		return combo;
	}

	
}
