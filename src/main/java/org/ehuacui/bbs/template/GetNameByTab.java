package org.ehuacui.bbs.template;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
import org.ehuacui.bbs.common.ServiceHolder;
import org.ehuacui.bbs.model.Section;

import java.util.List;

/**
 * 根据版块标识查询版块名称
 * Created by jianwei.zhou on 2016/9/7.
 */
public class GetNameByTab implements TemplateMethodModel {
    @Override
    public Object exec(List list) throws TemplateModelException {
        if (list == null || list.size() != 1) {
            throw new TemplateModelException("Wrong arguments");
        }
        String tab = (String) list.get(0);
        Section section = ServiceHolder.sectionService.findByTab(tab);
        if (section != null) {
            return section.getName();
        }
        return null;
    }
}