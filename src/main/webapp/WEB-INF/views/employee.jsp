<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <form:form method="post" modelAttribute="employee">
        <form:hidden path="id"></form:hidden>
        <fieldset class="form-group">
            <form:label path="fullName">Full Name</form:label>
            <form:input type="text" path="fullName" class="form-control" required="required"/>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="birthDate">Birth Date</form:label>
            <form:input type="text" path="birthDate" class="form-control" required="required"/>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="position">Position</form:label>
            <form:input type="text" path="position" class="form-control" required="required"/>
            <form:errors path="position" cssClass="text-warning"/>
        </fieldset>

        <button type="submit" class="btn btn-success">Add</button>
    </form:form>
</div>

<%@ include file="common/footer.jspf" %>

<script>
    $('#birthDate').datepicker({
        format: 'dd/mm/yyyy'
    });
</script>


