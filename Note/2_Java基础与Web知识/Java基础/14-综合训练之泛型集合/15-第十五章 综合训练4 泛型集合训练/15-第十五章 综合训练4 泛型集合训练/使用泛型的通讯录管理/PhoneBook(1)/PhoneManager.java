import java.util.*;

/**
 * 电话簿类，存放电话信息
 */
public class PhoneManager {
    /**
     *  使用List存放电话信息
     */
    public  List<Phone> phones = new ArrayList<Phone>();

    /**
     * 打印电话簿内所有的数据
     */
    public void printBooks() {
        //使用format的方式规范输出格式，使每一行对齐
        System.out.printf("%-10s","序号");
        System.out.printf("%-11s","姓名");
        System.out.printf("%-12s","电话型号");
        System.out.printf("%-16s","电话号码");
        System.out.println("");

        for (int i = 0; i < phones.size(); i++) {

            System.out.printf("%-11s",(i+1)+"");
            System.out.printf("%-11s",phones.get(i).getName());
            System.out.printf("%-15s",phones.get(i).getPhoneType());
            System.out.printf("%-15s",phones.get(i).getPhoneNumber());

            System.out.println("");
        }
        System.out.println("------------------------------");
    }

    /**
     * 通过下标查询某个电话的详细信息
     * @param  num 电话信息序号
     */
    public void printSingleBook(int num) {

        System.out.printf("%-11s","姓名");
        System.out.printf("%-12s","电话型号");
        System.out.printf("%-16s","电话号码");
        System.out.println("");

        System.out.printf("%-11s",phones.get(num-1).getName());
        System.out.printf("%-15s",phones.get(num-1).getPhoneType());
        System.out.printf("%-15s",phones.get(num-1).getPhoneNumber());
        System.out.println("");
        System.out.println("------------------------------");

    }

    /**
     * 删除指定号码的电话信息
     * @param phoneNumber 电话号码
     * @return java.lang.Boolean
     */
    public Boolean deletePhone(String phoneNumber) {
        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).getPhoneNumber().equals(phoneNumber)) {
                phones.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     *  向电话簿中添加电话信息
     * @param phone 新加入的电话信息
     * @return java.lang.Boolean
     */
    public Boolean addPhone(Phone phone) {
        //先遍历电话簿，检查电话号码是否重复
        for (int i = 0; i < phones.size(); i++) {
            //如果电话号码重复则添加失败
            if (phones.get(i).getPhoneNumber().equals(phone.getPhoneNumber())){
                return false;
            }
        }
        return phones.add(phone);
    }

    /**
     * 获取电话信息总数
     * @return int
     */
    public Integer getPhoneNumber( ) {
        return phones.size();
    }


}
