package Servlets;

import crud.FileCrud;
import crud.Lab2CrudI;

public class ServletConfig implements ServletConfigI{
    Lab2CrudI l2ci;

    public ServletConfig(){
        this.l2ci = new FileCrud();
    }

    public void setL2ci(Lab2CrudI l2ci) {
        this.l2ci = l2ci;
    }

    @Override
    public Lab2CrudI getCrud() {
        return l2ci;
    }
}
