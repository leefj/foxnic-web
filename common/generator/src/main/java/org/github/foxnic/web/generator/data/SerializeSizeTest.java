package org.github.foxnic.web.generator.data;

import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class SerializeSizeTest {

    public static void main(String [] args)
    {
        Person e = new Person();
        e.setName("李方捷");
        e.setId("12345678");
        e.setSource("宁波");
        e.setIdentity("330219185854225266");
        e.setCreateTime(new Date());
        e.setCreateBy("911");
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("d:\\person.obj");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }

}
