package main;

public class HashDemo {
    //加法hash
    static int additiveHash(String key, int prime) {
        int hash, i;
        for (hash = key.length(), i = 0; i < key.length(); i++)
            hash += key.charAt(i);
        return (hash % prime);
    }

    //位运算
    static int rotatingHash(String key, int prime) {
        int hash = key.length();
        for (int i = 0; i < key.length(); ++i)
            hash = (hash << 4) ^ (hash >> 28) ^ key.charAt(i);
        return (hash % prime);
    }
    /*
     * 1. hash = (hash<27)^key.charAt(i);
     * 2.hash += key.charAt(i);
     *    hash += (hash << 10);
     *    hash ^= (hash >> 6);
     * 3. if((i&1) == 0)
     *    {
     *        hash ^= (hash<3);
     *    }
     *    else
     *    {
     *        hash ^= ~((hash<5));
     *    }
     * 4. hash += (hash<<5) + key.charAt(i);
     * 5. hash = key.charAt(i) + (hash<16) – hash;
     * 6. hash ^= ((hash<2));
     */

    static int berstein(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); ++i) {
            hash = 33 * hash + key.charAt(i);
        }
        return hash;
    }
    /*
    使用这种方式的著名Hash函数还有：
    32位FNV算法
     */

}
