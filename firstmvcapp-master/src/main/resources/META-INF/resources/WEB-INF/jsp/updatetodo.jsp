<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">
    <h1>Add todo</h1>
    <form:form action="/update-todo" method="post" commandName="updatetodo">
        <fieldset class="form-group">
            <form:label path="desc">Description</form:label>
            <form:input path="desc" type="text" name="desc" required="required" class="form-control"></form:input>
            <form:errors path="desc" cssClass="text-warning" />
        </fieldset>
        <fieldset class="form-group">
            <form:label path="isDone">isDone</form:label>
            <form:input path="isDone" type="text" name="isDone" required="required" class="form-control"></form:input>
        </fieldset>
        <fieldset class="form-group">
            <form:label path="targetDate">Target Date</form:label>
            <form:input path="targetDate" type="text" name="targetDate" required="required" class="form-control" id="targetDate"></form:input>
        </fieldset>
    <fieldset>
        <fieldset>
            <form:input type="hidden" path="id" name="id" class="form-control"></form:input>
            <input type="submit" value="Update Todo" class="btn btn-success">
        </fieldset>
    </form:form>
</div>
<%@include file="common/footer.jspf"%>