package org.fm.type;

/**
 * 删除状态
 * @author richa
 *
 */
public enum IsDeleteType {
	ISDELETE_TYPE(0,"正常"),NOT_ISDELETE_TYPE(1,"已删除");


    IsDeleteType(int key, String val) {
        this.key = key;
        this.val = val;
    }

    private int key;
    private String val;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
    
}