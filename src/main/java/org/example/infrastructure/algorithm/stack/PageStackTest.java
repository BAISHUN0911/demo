package org.example.infrastructure.algorithm.stack;

/**
 * @description:
 * @Author BAISHUN
 * @Date 2024/8/31 17:17
 */
public class PageStackTest {

    private PageStack pageStack = new PageStack();

    // 进入新页面
    public void joinNewPage(String pageUrl) {
        System.out.println("用户进入了" + pageUrl);
        pageStack.push(pageUrl);
    }

    // 前进
    public String forwardPage() {
        System.out.println("用户点击前进");
        String forward = pageStack.forward();
        if(forward.isEmpty()) {
            return "refuse";
        }
        return forward;
    }

    // 后退
    public String retreatPage() {
        System.out.println("用户点击后退");
        String retreat = pageStack.retreat();
        if(retreat.isEmpty()) {
            return "refuse";
        }
        return retreat;
    }

    public static void main(String[] args) {
        PageStackTest user = new PageStackTest();
        user.joinNewPage("http://www.google.com");
        user.joinNewPage("http://www.baidu.com");
        System.out.println(user.forwardPage());     // 不可前进
        System.out.println(user.retreatPage());     // 退到谷歌
        System.out.println(user.forwardPage());     // 回到百度

        System.out.println(user.retreatPage());
        user.joinNewPage("http://www.github.com");      // 进到新页面
        System.out.println(user.forwardPage());     // 不可前进
        System.out.println(user.retreatPage());     // 退到谷歌
        System.out.println(user.retreatPage());     // 不可后退

    }
}
