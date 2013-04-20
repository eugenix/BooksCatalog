<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>


<s:include value="layouts/header.jsp" />

<div class="container">
    <div class="page-header">
        <h1>Settings</h1>
    </div>

    <div class="row">
        <div class="span5 well offset3">
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

            <s:form cssClass="form-horizontal" action="save-settings">
                <fieldset>
                    <legend>Change password</legend>
                    <div class="control-group">
                        <label class="control-label" for="password">Password</label>
                        <div class="controls">
                            <input type="password" id="password" name="password" placeholder="Password">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="newPassword">New password</label>
                        <div class="controls">
                            <input type="password" id="newPassword" name="newPassword" placeholder="New password">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="retypePassword">Retype password</label>
                        <div class="controls">
                            <input type="password" id="retypePassword" name="retypePassword" placeholder="Retype password">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <button type="submit" class="btn btn-primary btn-large">Change</button>
                        </div>
                    </div>
                </fieldset>
            </s:form>
        </div>
    </div>
</div>

<s:include value="layouts/footer.jsp" />
