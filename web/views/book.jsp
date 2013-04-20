<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:include value="layouts/header.jsp" />

<div class="container">
    <div class="page-header">
        <h1>Add book page</h1>
    </div>

    <div class="row">
        <div class="offset3 span6 well">
            <s:if test="hasErrors()">
                <div class="alert alert-error">
                    <a class="close" data-dismiss="alert" href="#">&times;</a>
                    <s:actionerror />
                    <s:fielderror />
                </div>
            </s:if>

            <s:if test="hasActionMessages()">
                <div class="alert alert-success">
                    <a class="close" data-dismiss="alert" href="#">&times;</a>
                    <s:actionmessage />
                </div>
            </s:if>

            <s:form cssClass="form-horizontal" action="save-book" method="POST">
                <fieldset>
                    <legend>Add book</legend>
                    <div class="control-group">
                        <label class="control-label" for="title">Title</label>
                        <div class="controls">
                            <input type="text" id="title" name="title" placeholder="Война и мир" class="span4" value="<s:property value="book.title"/>">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="author">Author</label>
                        <div class="controls">
                            <input type="text" id="author" name="authorName" placeholder="Лев Толстой" class="span4" value="<s:property value="book.authorName"/>">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="publisher">Publisher</label>
                        <div class="controls">
                            <input type="text" id="publisher" name="publisher" placeholder="Эксмо-Пресс" class="span4" value="<s:property value="book.publisher"/>">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="isbn">ISBN</label>
                        <div class="controls">
                            <input type="text" id="isbn" name="isbn" placeholder="5699318742" class="span4" value="<s:property value="book.isbn"/>">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="imageUrl">Image URL</label>
                        <div class="controls">
                            <input type="text" id="imageUrl" name="imageUrl" placeholder="http://example.com/image.png" class="span4" value="<s:property value="book.imageUrl"/>">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="price">Price</label>
                        <div class="controls">
                            <input type="text" id="price" name="price" placeholder="100.00" class="span4" value="<s:property value="book.price"/>">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="description">Annotation</label>
                        <div class="controls">
                            <textarea rows="3" id="description" name="description" class="span4"><s:property value="book.description"/></textarea>
                        </div>
                    </div>

                    <s:hidden name="id" value="%{book.id}"/>

                    <div class="form-actions">
                        <button type="submit" class="btn btn-large btn-primary">Save</button>
                        <button type="button" class="btn btn-large">Cancel</button>
                    </div>

                </fieldset>
            </s:form>
        </div>

    </div>
</div>

<s:include value="layouts/footer.jsp" />