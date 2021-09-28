package org.github.foxnic.web.generator.data;

import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.excel.ExcelColumn;
import com.github.foxnic.dao.excel.ExcelReader;
import com.github.foxnic.dao.excel.ExcelStructure;

import java.io.File;

public class ExcelR {

    public static void main(String[] args) throws Exception {

        String id=IDGenerator.getSnowflakeIdString();
        System.out.println(id);

        ExcelStructure es=new ExcelStructure();
        es.addColumn("C","name","资产名称",ExcelColumn.STRING_CELL_READER);
        es.addColumn("D","spec","规格型号",ExcelColumn.STRING_CELL_READER);

        ExcelReader reader=new ExcelReader(new File("d:\\eam_download_asset.xls"));
        RcdSet rs=reader.read(es);
        System.out.println(rs.toJSONArrayWithJSONObject());

    }

}
