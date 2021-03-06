<%--
  Created by IntelliJ IDEA.
  User: zengqiang
  Date: 2018/4/22
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>

<%--@elvariable id="articles" type="java.util.List<com.boke.pojo.Article>"--%>
<%--@elvariable id="user" type="com.boke.pojo.User"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="gb2312">
    <title>个人博客模板（寻梦）</title>
    <meta name="keywords" content="个人博客模板,博客模板" />
    <meta name="description" content="寻梦主题的个人博客模板，优雅、稳重、大气,低调。" />
    <link href="${pageContext.request.contextPath}/blog/css/base.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/blog/css/index.css" rel="stylesheet">
    <style type="text/css">
        .dd
        {
            margin-left: -1em;
            text-align: left;//左对齐
            text-indent: 5em;
            line-height: 24px;//行高
            display:block;
            height:73px;
            overflow:hidden;
            width:550px;
        }</style>
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/blog/js/modernizr.js" ">
    </script>
    <![endif]-->
    <script type="text/javascript">

        function changeLink(a,b) {

            var s=a+"/article/preview?"+JSON.stringify(b);
            return s;
        }
    </script>
</head>
<body>
<header>
    <div id="logo"><a href="/"></a></div>
    <nav class="topnav" id="topnav"><a
            href="index.html"><span>首页</span><span class="en">Protal</span></a><a
            href="about.html"><span>关于我</span><span class="en">About</span></a><a
            href="newlist.html"><span>慢生活</span><span class="en">Life</span></a><a
            href="moodlist.html"><span>碎言碎语</span><span class="en">Doing</span></a><a
            href="${base}/user/article/writearticle.do"><span>写博客</span><span class="en">write</span></a><a
            href="knowledge.html"><span>学无止境</span><span class="en">Learn</span></a><a
            href="book.html"><span>留言版</span><span class="en">Gustbook</span></a><a
            href="../login/index.html"><span>登录</span><span class="en">Login</span></a>
    </nav>
    </nav>
</header>
<div class="banner">
    <section class="box">
        <ul class="texts">
            <p>打了死结的青春，捆死一颗苍白绝望的灵魂。</p>
            <p>为自己掘一个坟墓来葬心，红尘一梦，不再追寻。</p>
            <p>加了锁的青春，不会再因谁而推开心门。</p>
        </ul>
        <div class="avatar"><a href="#"><span>${user.nickName}</span></a> </div>
    </section>
</div>
<%--<div class="template">
    <div class="box">
        <h3>
            <p><span>个人博客</span>模板 Templates</p>
        </h3>
        <ul>
            <li><a href="/"  target="_blank"><img src="${pageContext.request.contextPath}/blog/images/01.jpg"></a><span>仿新浪博客风格・梅――古典个人博客模板</span></li>
            <li><a href="/" target="_blank"><img src="${pageContext.request.contextPath}/blog/images/02.jpg"></a><span>黑色质感时间轴html5个人博客模板</span></li>
            <li><a href="/"  target="_blank"><img src="${pageContext.request.contextPath}/blog/images/03.jpg"></a><span>Green绿色小清新的夏天-个人博客模板</span></li>
            <li><a href="/" target="_blank"><img src="${pageContext.request.contextPath}/blog/images/04.jpg"></a><span>女生清新个人博客网站模板</span></li>
            <li><a href="/"  target="_blank"><img src="${pageContext.request.contextPath}/blog/images/02.jpg"></a><span>黑色质感时间轴html5个人博客模板</span></li>
            <li><a href="/"  target="_blank"><img src="${pageContext.request.contextPath}/blog/images/03.jpg"></a><span>Green绿色小清新的夏天-个人博客模板</span></li>
        </ul>
    </div>
</div>--%>
<article>
    <h2 class="title_tj">
        <p>我的博客</p>
    </h2>

    <div class="bloglist left">
        <c:forEach var="article" items="${articles}">
            <h3>${article.title}</h3>
            <figure><img src="${pageContext.request.contextPath}/blog/images/001.png"></figure>
            <ul>
                <div class="dd" >${article.essay}</div>
                <a title="/" href="${base}/article/preview?articleid=${article.articleId}"  target="_blank" class="readmore">详情>></a>
            </ul>
            <p class="dateview"><span>${article.createTime}</span><span>作者：${user.nickName}</span><span>博主首页：[<a href="/news/life/">程序人生</a>]</span></p>
        </c:forEach>
       <%-- <h3>${article.title}</h3>
        <figure><img src="${pageContext.request.contextPath}/blog/images/001.png"></figure>
        <ul>
            <p>如果说掌握一门赖以生计的技术是技术人员要学会的第一课的话， 那么我觉得技术人员要真正学会的第二课，不是技术，而是业务、交流与协作，学会关心其他工作伙伴的工作情况和进展...</p>
            <a title="/" href="/" target="_blank" class="readmore">修改>></a>
        </ul>
        <p class="dateview"><span>${article.createTime}</span><span>作者：杨青</span><span>个人博客：[<a href="/news/life/">程序人生</a>]</span></p>


        <h3>${article.title}</h3>
        <figure><img src="${pageContext.request.contextPath}/blog/images/001.png"></figure>
        <ul>
            <p>如果说掌握一门赖以生计的技术是技术人员要学会的第一课的话， 那么我觉得技术人员要真正学会的第二课，不是技术，而是业务、交流与协作，学会关心其他工作伙伴的工作情况和进展...</p>
            <a title="/" href="${pageContext.request.contextPath}/article/viewtitle?title=Just about me" target="_blank" class="readmore">修改>></a>
        </ul>
        <p class="dateview"><span>${article.createTime}</span><span>作者：杨青</span><span>个人博客：[<a href="/news/life/">程序人生</a>]</span></p>
        <h3>${article.title}</h3>
        <figure><img src="${pageContext.request.contextPath}/blog/images/001.png"></figure>
        <ul>
            <p>如果说掌握一门赖以生计的技术是技术人员要学会的第一课的话， 那么我觉得技术人员要真正学会的第二课，不是技术，而是业务、交流与协作，学会关心其他工作伙伴的工作情况和进展...</p>
            <a title="/" href="/" target="_blank" class="readmore">修改>></a>
        </ul>
        <p class="dateview"><span>${article.createTime}</span><span>作者：杨青</span><span>个人博客：[<a href="/news/life/">程序人生</a>]</span></p>
        <h3>${article.title}</h3>
        <figure><img src="${pageContext.request.contextPath}/blog/images/001.png"></figure>
        <ul>
            <p>如果说掌握一门赖以生计的技术是技术人员要学会的第一课的话， 那么我觉得技术人员要真正学会的第二课，不是技术，而是业务、交流与协作，学会关心其他工作伙伴的工作情况和进展...</p>
            <a title="/" href="/" target="_blank" class="readmore">修改>></a>
        </ul>
        <p class="dateview"><span>${article.createTime}</span><span>作者：杨青</span><span>个人博客：[<a href="/news/life/">程序人生</a>]</span></p>
        <h3>${article.title}</h3>
        <figure><img src="${pageContext.request.contextPath}/blog/images/001.png"></figure>
        <ul>
            <p>如果说掌握一门赖以生计的技术是技术人员要学会的第一课的话， 那么我觉得技术人员要真正学会的第二课，不是技术，而是业务、交流与协作，学会关心其他工作伙伴的工作情况和进展...</p>
            <a title="/" href="/" target="_blank" class="readmore">修改>></a>
        </ul>
        <p class="dateview"><span>${article.createTime}</span><span>作者：杨青</span><span>个人博客：[<a href="/news/life/">程序人生</a>]</span></p>--%>
    </div>
    <aside class="right">
        <div class="weather"><iframe width="250" scrolling="no" height="60" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=1"></iframe></div>
        <div class="news">
            <h3>
                <p>最新<span>文章</span></p>
            </h3>
            <ul class="rank">
                <li><a href="/" title="Column 三栏布局 个人网站模板" target="_blank">Column 三栏布局 个人网站模板</a></li>
                <li><a href="/" title="with love for you 个人网站模板" target="_blank">with love for you 个人网站模板</a></li>
                <li><a href="/" title="免费收录网站搜索引擎登录口大全" target="_blank">免费收录网站搜索引擎登录口大全</a></li>
                <li><a href="/" title="做网站到底需要什么?" target="_blank">做网站到底需要什么?</a></li>
                <li><a href="/" title="企业做网站具体流程步骤" target="_blank">企业做网站具体流程步骤</a></li>
                <li><a href="/" title="建站流程篇――教你如何快速学会做网站" target="_blank">建站流程篇――教你如何快速学会做网站</a></li>
                <li><a href="/" title="box-shadow 阴影右下脚折边效果" target="_blank">box-shadow 阴影右下脚折边效果</a></li>
                <li><a href="/" title="打雷时室内、户外应该需要注意什么" target="_blank">打雷时室内、户外应该需要注意什么</a></li>
            </ul>
            <h3 class="ph">
                <p>点击<span>排行</span></p>
            </h3>
            <ul class="paih">
                <li><a href="/" title="Column 三栏布局 个人网站模板" target="_blank">Column 三栏布局 个人网站模板</a></li>
                <li><a href="/" title="withlove for you 个人网站模板" target="_blank">with love for you 个人网站模板</a></li>
                <li><a href="/" title="免费收录网站搜索引擎登录口大全" target="_blank">免费收录网站搜索引擎登录口大全</a></li>
                <li><a href="/" title="做网站到底需要什么?" target="_blank">做网站到底需要什么?</a></li>
                <li><a href="/" title="企业做网站具体流程步骤" target="_blank">企业做网站具体流程步骤</a></li>
            </ul>
            <h3 class="links">
                <p>友情<span>链接</span></p>
            </h3>
            <ul class="website">
                <li><a href="/">个人博客</a></li>
                <li><a href="/">谢泽文个人博客</a></li>
                <li><a href="/">3DST技术网</a></li>
                <li><a href="/">思衡网络</a></li>
            </ul>
        </div>
        <!-- Baidu Button BEGIN -->
        <div id="bdshare" class="bdshare_t bds_tools_32 get-codes-bdshare"><a class="bds_tsina"></a><a class="bds_qzone"></a><a class="bds_tqq"></a><a class="bds_renren"></a><span class="bds_more"></span><a class="shareCount"></a></div>
        <script type="text/javascript" id="bdshare_js" data="type=tools&amp;uid=6574585" ></script>
        <script type="text/javascript" id="bdshell_js"></script>
        <script type="text/javascript">
            document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/${pageContext.request.contextPath}/blog/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000)
        </script>
        <!-- Baidu Button END -->
        <a href="/" class="weixin"> </a></aside>
</article>
<footer>
    <p>Design by DanceSmile <a href="http://www.miitbeian.gov.cn/" target="_blank">蜀ICP备11002373号-1</a> <a href="/">网站统计</a></p>
</footer>
<script src="${pageContext.request.contextPath}/blog/js/silder.js"></script>
</body>
</html>