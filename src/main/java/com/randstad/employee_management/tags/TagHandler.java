package com.randstad.employee_management.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagHandler extends TagSupport {
    private String val;

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out=pageContext.getOut();
            if(val.length()>20){
                out.print(val.substring(0,20)+"...");
            }else{
                out.print(val);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
