package com.niko.pojo;
/*
* -- 创建表 apply_info，如果不存在的话
CREATE TABLE IF NOT EXISTS apply_info (
    applyId INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    class VARCHAR(50),
    game VARCHAR(50) NOT NULL
);

-- 插入初始化数据
INSERT INTO apply_info (class, game, name, age)
VALUES
    ('ClassA', 'Basketball', '张三', 20),
    ('ClassB', 'Football', '李四', 22),
    ('ClassC', 'Swimming', '王五', 25),
    ('ClassA', 'Basketball', '赵六', 21),
    ('ClassB', 'Football', '钱七', 23),
    ('ClassC', 'Swimming', '孙八', 24);

SELECT * FROM apply_info;
* */
public class ApplyInfo {
    private Integer applyId;
    private String name;
    private Integer age;
    private String className;
    private String game;

    public ApplyInfo() {
    }

    public ApplyInfo(String name, Integer age, String className, String game) {
        this.name = name;
        this.age = age;
        this.className = className;
        this.game = game;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "ApplyInfo{" +
                "applyId=" + applyId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                ", game='" + game + '\'' +
                '}';
    }
}


