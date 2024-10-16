## Day6 力扣2306：公司命名（困难）

### 2024年9月25日10:11:16

> [2306. 公司命名](https://leetcode.cn/problems/naming-a-company/)
>
> 给你一个字符串数组 `ideas` 表示在公司命名过程中使用的名字列表。公司命名流程如下：
>
> 1. 从 `ideas` 中选择 2 个 **不同** 名字，称为 `ideaA` 和 `ideaB` 。
> 2. 交换 `ideaA` 和 `ideaB` 的首字母。
> 3. 如果得到的两个新名字 **都** 不在 `ideas` 中，那么 `ideaA ideaB`（**串联** `ideaA` 和 `ideaB` ，中间用一个空格分隔）是一个有效的公司名字。
> 4. 否则，不是一个有效的名字。
>
> 返回 **不同** 且有效的公司名字的数目。
>
> **示例 1：**
>
> ```
> 输入：ideas = ["coffee","donuts","time","toffee"]
> 输出：6
> 解释：下面列出一些有效的选择方案：
> - ("coffee", "donuts")：对应的公司名字是 "doffee conuts" 。
> - ("donuts", "coffee")：对应的公司名字是 "conuts doffee" 。
> - ("donuts", "time")：对应的公司名字是 "tonuts dime" 。
> - ("donuts", "toffee")：对应的公司名字是 "tonuts doffee" 。
> - ("time", "donuts")：对应的公司名字是 "dime tonuts" 。
> - ("toffee", "donuts")：对应的公司名字是 "doffee tonuts" 。
> 因此，总共有 6 个不同的公司名字。
> 
> 下面列出一些无效的选择方案：
> - ("coffee", "time")：在原数组中存在交换后形成的名字 "toffee" 。
> - ("time", "toffee")：在原数组中存在交换后形成的两个名字。
> - ("coffee", "toffee")：在原数组中存在交换后形成的两个名字。
> ```
>
> **示例 2：**
>
> ```
> 输入：ideas = ["lack","back"]
> 输出：0
> 解释：不存在有效的选择方案。因此，返回 0 。
> ```
>
> **提示：**
>
> - `2 <= ideas.length <= 5 * 104`
> - `1 <= ideas[i].length <= 10`
> - `ideas[i]` 由小写英文字母组成
> - `ideas` 中的所有字符串 **互不相同**

```java
class Solution {
    public long distinctNames(String[] ideas) {
        
         // 存储原名称到集合  
        Set<String> ideaSet = new HashSet<>();  
        for (String idea : ideas) {  
            ideaSet.add(idea);  
        }  
        
        long validCount = 0; // 使用 long 类型  
        int n = ideas.length;  

        // 遍历 pairs of ideas  
        for (int i = 0; i < n; i++) {  
            for (int j = 0; j < n; j++) {  
                // 确保两个名字不同  
                if (i != j) {  
                    // 交换首字母  
                    String ideaA = ideas[i];  
                    String ideaB = ideas[j];  

                    char newFirstCharA = ideaB.charAt(0);  
                    char newFirstCharB = ideaA.charAt(0);  

                    // 新的名称  
                    String newNameA = newFirstCharA + ideaA.substring(1);  
                    String newNameB = newFirstCharB + ideaB.substring(1);  
                    
                    // 检查新名称是否有效  
                    if (!ideaSet.contains(newNameA) && !ideaSet.contains(newNameB)) {  
                        validCount++;  
                    }  
                }  
            }  
        }  

        return validCount; // 返回有效组合数  
    }
}
```

超时

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public long distinctNames(String[] ideas) {
        // 创建 26 个集合分别存储不同首字母的后缀
        Set<String>[] suffixes = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            suffixes[i] = new HashSet<>();
        }
        
        // 将每个名字按首字母分类，存储后缀
        for (String idea : ideas) {
            char firstChar = idea.charAt(0);
            suffixes[firstChar - 'a'].add(idea.substring(1));
        }
        
        long validCount = 0;

        // 遍历所有不同的首字母组合
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                int mutualSuffixes = 0;

                // 统计 i 和 j 组中有相同后缀的名字
                for (String suffix : suffixes[i]) {
                    if (suffixes[j].contains(suffix)) {
                        mutualSuffixes++;
                    }
                }

                // 有效组合是 i 和 j 组互换后没有相同后缀的名字
                int countA = suffixes[i].size() - mutualSuffixes;
                int countB = suffixes[j].size() - mutualSuffixes;

                validCount += countA * countB * 2;  // 两个方向的组合
            }
        }

        return validCount;
    }
}

```

没有开long；现在的代码只是简单地基于首字母进行计数，没有检查组合后的名字是否有效(生成新的公司名字组合后，应该检查生成的名字是否已经存在于 `ideaSet` 中)。

```java
class Solution {
    public long distinctNames(String[] ideas) {
        int[] cnts = new int[26];
        int[][] intterCnts = new int [26][26];
        Map<String, boolean[]> suffix2Pre = new HashMap<>(32);
        for(String idea : ideas){
            int pre = idea.charAt(0) - 'a';
            String suffix = idea.substring(1);
            cnts[pre]++;
            boolean[] preMask = suffix2Pre.getOrDefault(suffix, new boolean[26]);
            for(int i = 0; i < 26; i++){
                if(preMask[i]){
                    intterCnts[i][pre]++;
                    intterCnts[pre][i]++;
                }
            }
            preMask[pre] = true;
            suffix2Pre.put(suffix, preMask);
        }
        long res = 0L;
        for(int i = 1; i < 26; i++){
            for(int j = 0; j < i; j++){
                res+=(cnts[i] - intterCnts[i][j]) * (cnts[j] - intterCnts[i][j]);
            }
        }
        return res * 2;
    }
}
```

```java
class Solution {
    public long distinctNames(String[] ideas) {
        // 统计同一首字母的字符串数量 集合大小
        int[] size = new int[26];
        // 统计不同首字母中相同后缀的数量，即交集
        int[][] intersection = new int[26][26];
        // 统计不同后缀在哪些集合中 Integer使用位来判断
        HashMap<String,Integer> hm = new HashMap<>();

        for(String s: ideas){
            int c = s.charAt(0) - 'a';
            size[c]++;

            String suf = s.substring(1);
            int m = hm.getOrDefault(suf,0);
            hm.put(suf, m|1<<c);
            for(int i = 0; i < 26; i++){
                if(( m >> i & 1) == 1){
                    intersection[i][c]++;
                    intersection[c][i]++;
                }
            } 
        }

        long res = 0;
        for(int i = 1; i < 26; i++){
            for(int j = 0; j < i; j++){
                int m = intersection[i][j];
                res += (size[i] - m) * (size[j] - m);
            }
        }
        return res*2;
    }
}
```

```java
class Solution {
    public long distinctNames(String[] ideas) {
        int[] size = new int[26]; // 集合大小
        int[][] intersection = new int[26][26]; // 交集大小
        Map<String, Integer> groups = new HashMap<>(); // 后缀 -> 首字母
        for (String s : ideas) {
            int b = s.charAt(0) - 'a';
            size[b]++; // 增加集合大小
            String suffix = s.substring(1);
            int mask = groups.getOrDefault(suffix, 0);
            groups.put(suffix, mask | 1 << b); // 把 b 加到 mask 中
            for (int a = 0; a < 26; a++) { // a 是和 s 有着相同后缀的字符串的首字母
                if ((mask >> a & 1) > 0) { // a 在 mask 中
                    ++intersection[b][a]; // 增加交集大小
                    ++intersection[a][b];
                }
            }
        }

        long ans = 0;
        for (int a = 1; a < 26; a++) { // 枚举所有组对
            for (int b = 0; b < a; b++) {
                int m = intersection[a][b];
                ans += (long) (size[a] - m) * (size[b] - m);
            }
        }
        return ans << 1; // 乘 2 放到最后
    }
}
```

