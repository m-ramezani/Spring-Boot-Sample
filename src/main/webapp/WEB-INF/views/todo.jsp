<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <form:form method="post" modelAttribute="todo">
        <form:hidden path="id"></form:hidden>
        <fieldset class="form-group">
            <form:label path="desc">Description</form:label>
            <form:input type="text" path="desc" class="form-control" required="required"/>
            <form:errors path="desc" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="targetDate">Target Date</form:label>
            <form:input type="text" path="targetDate" class="form-control" required="required"/>
            <form:errors path="desc" cssClass="text-warning"/>
        </fieldset>

        <button type="submit" class="btn btn-success">Add</button>
    </form:form>
</div>

<%@ include file="common/footer.jspf" %>

<script>
    $('#targetDate').datepicker({
        format: 'dd/mm/yyyy'
    });
</script>

