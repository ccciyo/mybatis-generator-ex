package com.ccciyo.mybatis;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.internal.DefaultCommentGenerator;

public class CommentGenerator extends DefaultCommentGenerator {


    public CommentGenerator() {
        super();
    }


    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        addComment(field, introspectedColumn.getRemarks());
    }



    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addJavaDocLine(introspectedTable.getRemarks());
        addComment(topLevelClass, introspectedTable.getRemarks());
    }


    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        addComment(method, introspectedColumn.getRemarks());
    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        addComment(method, introspectedColumn.getRemarks());
    }

    private void addComment(JavaElement element, String remarks) {
        if (remarks == null || remarks.trim().length() == 0) {
            return;
        }
        element.addJavaDocLine("/**");
        String[] remarkLines = remarks.split(System.getProperty("line.separator"));
        for (String remarkLine : remarkLines) {
            element.addJavaDocLine(" *   " + remarkLine);
        }
        element.addJavaDocLine(" */");
    }
}
