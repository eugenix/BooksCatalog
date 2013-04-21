<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:include value="layouts/header.jsp" />

<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>Home page</h1>
        </div>
    </div>

    <div class="row">
        <div class="well span20">
            <s:form action="search" method="get">
                <fieldset>
                    <legend>Find book</legend>

                    <label>Title</label>
                    <input type="text" class="span3" name="title" placeholder="Война и мир" value="<s:property value="title"/>">

                    <label>Author</label>
                    <input type="text" class="span3" name="authorName" placeholder="Лев Толстой" value="<s:property value="authorName"/>">

                    <label>Publisher</label>
                    <input type="text" class="span3" name="publisher" placeholder="Эксмо-Пресс" value="<s:property value="publisher"/>">

                    <label>ISBN</label>
                    <input type="text" class="span3"  name="isbn" placeholder="5699318742" value="<s:property value="isbn"/>">
                    <button type="submit" class="btn btn-primary btn-large"><i class="icon-search icon-white"></i> Search!</button>

                    <input type="hidden" name="pageNumber" value="1"/>

                </fieldset>
            </s:form>
        </div>
        <div class="span21">
            <ul class="media-list">
                <s:if test="books.size() > 0">
                    <s:iterator value="books">
                        <li class="media well">
                            <a href="#" class="pull-left">
                                <img style="width: 150px; height: 150px;" src="<s:property value="imageUrl"/>">
                            </a>
                            <div class="media-body">
                                <h4 class="media-heading">
                                    <a href="<s:url action="book"><s:param name="bookId" value="%{id}"/></s:url>">
                                        <s:property value="title"/>
                                    </a>
                                </h4>
                                <div class="row">
                                    <div class="span22">
                                        <dl class="dl-horizontal text-left">
                                            <dt>Author:</dt>
                                            <dd><s:property value="authorName"/></dd>
                                            <dt>Publisher:</dt>
                                            <dd><s:property value="publisher"/></dd>
                                            <dt>ISBN:</dt>
                                            <dd><s:property value="isbn"/></dd>
                                        </dl>
                                    </div>
                                    <div class="span1">
                                        <span class="badge badge-info btn-large"><s:property value="price"/> р</span>
                                    </div>
                                </div>
                                <p><s:property value="description"/></p>
                            </div>
                        </li>
                        <hr />
                    </s:iterator>
                </s:if>
                <s:else>
                    <li class="media well">No results found</li>
                </s:else>
            </ul>

            <s:if test="totalPages > 1">
                <div class="offset1 pagination pagination-centered">
                    <ul>
                        <s:if test="pageNumber > 1">
                            <li><a href="<s:url action="search">
                                <s:param name="title" value="%{title}"/>
                                <s:param name="authorName" value="%{authorName}"/>
                                <s:param name="publisher" value="%{publisher}"/>
                                <s:param name="isbn" value="%{isbn}"/>
                                <s:param name="pageNumber" value="%{pageNumber-1}"/>
                            </s:url>">← Previous</a></li>
                        </s:if>
                        <s:iterator begin="1" end="%{totalPages}" status="pages">
                            <li class="<s:if test='pageNumber == #pages.count'>active</s:if>">
                                <a href="<s:url action="search">
                                    <s:param name="title" value="%{title}"/>
                                    <s:param name="authorName" value="%{authorName}"/>
                                    <s:param name="publisher" value="%{publisher}"/>
                                    <s:param name="isbn" value="%{isbn}"/>
                                    <s:param name="pageNumber" value="%{#pages.count}"/>
                                </s:url>"><s:property/>
                                </a>
                            </li>
                        </s:iterator>
                        <s:if test="pageNumber < totalPages">
                            <li><a href="<s:url action="search">
                                <s:param name="title" value="%{title}"/>
                                <s:param name="authorName" value="%{authorName}"/>
                                <s:param name="publisher" value="%{publisher}"/>
                                <s:param name="isbn" value="%{isbn}"/>
                                <s:param name="pageNumber" value="%{pageNumber+1}"/>
                            </s:url>">Next →</a></li>
                        </s:if>
                    </ul>
                </div>
            </s:if>
        </div>
    </div>
</div>

<s:include value="layouts/footer.jsp" />
