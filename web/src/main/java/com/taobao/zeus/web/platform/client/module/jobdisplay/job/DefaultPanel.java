package com.taobao.zeus.web.platform.client.module.jobdisplay.job;

import com.google.gwt.user.client.ui.Frame;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SubmitCompleteEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.event.SubmitCompleteEvent.SubmitCompleteHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FileUploadField;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.FormPanel.Encoding;
import com.sencha.gxt.widget.core.client.form.FormPanel.Method;

public class DefaultPanel extends Window {
	public DefaultPanel(final String id){
		setModal(true);
		setSize("600", "500");
		setHeadingText("自动生成脚本");
		
		FramedPanel fp=new FramedPanel();
		fp.setHeaderVisible(false);
		fp.setButtonAlign(BoxLayoutPack.CENTER);
		
		
		Frame frame = new Frame("/zeus-web/lingoes.html");
		fp.add(frame);
		
		add(fp,new MarginData(5));
	}

}