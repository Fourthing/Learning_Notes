/* v1.0
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo01_generics {
    public static void main(String[] args) {
        List<String> newsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // 添加初始化数据
        newsList.add("新闻1：关于Java的最新动态");
        newsList.add("新闻2：科技公司发布新产品");
        newsList.add("新闻3：全球气候变化问题");
        newsList.add("新闻4：经济增长预测");
        newsList.add("新闻5：体育赛事最新报道");

        // 添加多个新闻的信息到集合中
        System.out.println("请输入要添加的新闻条数：");
        int n = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        for (int i = 0; i < n; i++) {
            System.out.println("请输入第 " + (i + 1) + " 条新闻：");
            String newsItem = scanner.nextLine();
            newsList.add(newsItem);
        }

        // 查看新闻的数量及所有新闻的信息
        System.out.println("新闻的数量：" + newsList.size());
        System.out.println("所有新闻的信息：");
        for (String news : newsList) {
            System.out.println(news);
        }

        // 删除集合中部分新闻的元素
        System.out.println("请输入要删除的新闻：");
        String itemToRemove = scanner.nextLine();
        if (newsList.remove(itemToRemove)) {
            System.out.println("已删除：" + itemToRemove);
        } else {
            System.out.println("新闻未找到。");
        }

        // 判断集合中是否包含指定新闻
        System.out.println("请输入要查找的新闻：");
        String itemToCheck = scanner.nextLine();
        if (newsList.contains(itemToCheck)) {
            System.out.println("集合中包含新闻：" + itemToCheck);
        } else {
            System.out.println("集合中不包含新闻：" + itemToCheck);
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
        return "新闻" + id + "：" + content;
    }
}

/**
	2024年7月1日08:31:04
	增加了选择操作的功能，为每条新闻增加了序号，便于查询和修改。
	@author NiKo
	@version v1.1 
*/
public class Demo01_generics {
    private static List<NewsItem> newsList = new ArrayList<>();
    private static int nextId = 1;
    private static Scanner scanner = new Scanner(System.in);
/**
	整数输入：nextInt() 只读取数值，不读取换行符。
	字符串输入：nextLine() 读取整行，包括换行符。
	消耗换行符：在混合使用 nextInt() 和 nextLine() 时，使用 scanner.nextLine() 来消耗多余的换行符，确保输入正确。
	println 方法内部自动调用 toString 方法（如果对象内容非空的话）
*/
    public static void main(String[] args) {
        initializeData();
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符
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
                    System.out.println("退出程序。");
                    return;
                default:
                    System.out.println("无效的选择，请重试。");
            }
        }
    }

    private static void showMenu() {
        System.out.println("请选择一个功能：");
        System.out.println("1. 添加新闻");
        System.out.println("2. 查看所有新闻");
        System.out.println("3. 删除新闻");
        System.out.println("4. 查询新闻");
        System.out.println("5. 退出");
    }

    private static void initializeData() {
        newsList.add(new NewsItem(nextId++, "关于Java的最新动态"));
        newsList.add(new NewsItem(nextId++, "科技公司发布新产品"));
        newsList.add(new NewsItem(nextId++, "全球气候变化问题"));
        newsList.add(new NewsItem(nextId++, "经济增长预测"));
        newsList.add(new NewsItem(nextId++, "体育赛事最新报道"));
    }

    private static void addNews() {
        System.out.println("请输入要添加的新闻内容：");
        String content = scanner.nextLine();
        newsList.add(new NewsItem(nextId++, content));
        System.out.println("新闻已添加。");
    }

    private static void viewNews() {
        System.out.println("新闻的数量：" + newsList.size());
        System.out.println("所有新闻的信息：");
        for (NewsItem news : newsList) {
            System.out.println(news);
        }
    }

    private static void deleteNews() {
        System.out.println("请输入要删除的新闻序号：");
        int id = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符
        boolean removed = newsList.removeIf(news -> news.id == id);
        if (removed) {
            System.out.println("新闻已删除。");
        } else {
            System.out.println("新闻未找到。");
        }
    }

    private static void checkNews() {
        System.out.println("请输入要查询的新闻序号：");
        int id = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符
        boolean found = false;
        for (NewsItem news : newsList) {
            if (news.id == id) {
                System.out.println("找到新闻：" + news);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("未找到指定序号的新闻。");
        }
    }
}
