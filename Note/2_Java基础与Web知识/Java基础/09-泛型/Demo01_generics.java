/* v1.0
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo01_generics {
    public static void main(String[] args) {
        List<String> newsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // ��ӳ�ʼ������
        newsList.add("����1������Java�����¶�̬");
        newsList.add("����2���Ƽ���˾�����²�Ʒ");
        newsList.add("����3��ȫ������仯����");
        newsList.add("����4����������Ԥ��");
        newsList.add("����5�������������±���");

        // ��Ӷ�����ŵ���Ϣ��������
        System.out.println("������Ҫ��ӵ�����������");
        int n = scanner.nextInt();
        scanner.nextLine(); // ���Ļ��з�

        for (int i = 0; i < n; i++) {
            System.out.println("������� " + (i + 1) + " �����ţ�");
            String newsItem = scanner.nextLine();
            newsList.add(newsItem);
        }

        // �鿴���ŵ��������������ŵ���Ϣ
        System.out.println("���ŵ�������" + newsList.size());
        System.out.println("�������ŵ���Ϣ��");
        for (String news : newsList) {
            System.out.println(news);
        }

        // ɾ�������в������ŵ�Ԫ��
        System.out.println("������Ҫɾ�������ţ�");
        String itemToRemove = scanner.nextLine();
        if (newsList.remove(itemToRemove)) {
            System.out.println("��ɾ����" + itemToRemove);
        } else {
            System.out.println("����δ�ҵ���");
        }

        // �жϼ������Ƿ����ָ������
        System.out.println("������Ҫ���ҵ����ţ�");
        String itemToCheck = scanner.nextLine();
        if (newsList.contains(itemToCheck)) {
            System.out.println("�����а������ţ�" + itemToCheck);
        } else {
            System.out.println("�����в��������ţ�" + itemToCheck);
        }

        scanner.close();
    }
}
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NewsItem {
    int id;
    String content;

    NewsItem(int id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return "����" + id + "��" + content;
    }
}

/**
	2024��7��1��08:31:04
	������ѡ������Ĺ��ܣ�Ϊÿ��������������ţ����ڲ�ѯ���޸ġ�
	@author NiKo
	@version v1.1 
*/
public class Demo01_generics {
    private static List<NewsItem> newsList = new ArrayList<>();
    private static int nextId = 1;
    private static Scanner scanner = new Scanner(System.in);
/**
	�������룺nextInt() ֻ��ȡ��ֵ������ȡ���з���
	�ַ������룺nextLine() ��ȡ���У��������з���
	���Ļ��з����ڻ��ʹ�� nextInt() �� nextLine() ʱ��ʹ�� scanner.nextLine() �����Ķ���Ļ��з���ȷ��������ȷ��
	println �����ڲ��Զ����� toString ����������������ݷǿյĻ���
*/
    public static void main(String[] args) {
        initializeData();
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // ���Ļ��з�
            switch (choice) {
                case 1:
                    addNews();
                    break;
                case 2:
                    viewNews();
                    break;
                case 3:
                    deleteNews();
                    break;
                case 4:
                    checkNews();
                    break;
                case 5:
                    System.out.println("�˳�����");
                    return;
                default:
                    System.out.println("��Ч��ѡ�������ԡ�");
            }
        }
    }

    private static void showMenu() {
        System.out.println("��ѡ��һ�����ܣ�");
        System.out.println("1. �������");
        System.out.println("2. �鿴��������");
        System.out.println("3. ɾ������");
        System.out.println("4. ��ѯ����");
        System.out.println("5. �˳�");
    }

    private static void initializeData() {
        newsList.add(new NewsItem(nextId++, "����Java�����¶�̬"));
        newsList.add(new NewsItem(nextId++, "�Ƽ���˾�����²�Ʒ"));
        newsList.add(new NewsItem(nextId++, "ȫ������仯����"));
        newsList.add(new NewsItem(nextId++, "��������Ԥ��"));
        newsList.add(new NewsItem(nextId++, "�����������±���"));
    }

    private static void addNews() {
        System.out.println("������Ҫ��ӵ��������ݣ�");
        String content = scanner.nextLine();
        newsList.add(new NewsItem(nextId++, content));
        System.out.println("��������ӡ�");
    }

    private static void viewNews() {
        System.out.println("���ŵ�������" + newsList.size());
        System.out.println("�������ŵ���Ϣ��");
        for (NewsItem news : newsList) {
            System.out.println(news);
        }
    }

    private static void deleteNews() {
        System.out.println("������Ҫɾ����������ţ�");
        int id = scanner.nextInt();
        scanner.nextLine(); // ���Ļ��з�
        boolean removed = newsList.removeIf(news -> news.id == id);
        if (removed) {
            System.out.println("������ɾ����");
        } else {
            System.out.println("����δ�ҵ���");
        }
    }

    private static void checkNews() {
        System.out.println("������Ҫ��ѯ��������ţ�");
        int id = scanner.nextInt();
        scanner.nextLine(); // ���Ļ��з�
        boolean found = false;
        for (NewsItem news : newsList) {
            if (news.id == id) {
                System.out.println("�ҵ����ţ�" + news);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("δ�ҵ�ָ����ŵ����š�");
        }
    }
}
