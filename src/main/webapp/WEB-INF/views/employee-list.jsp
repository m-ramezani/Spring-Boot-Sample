<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <table class="table table-striped">
        <caption>Employees are:</caption>
        <thead>
        <tr>
            <th>Full Name</th>
            <th>BirthDate Date</th>
            <th>Position</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employees}" var="item">
            <tr>
                <td>${item.fullName}</td>
                <td>
                    <fmt:formatDate value="${item.birthDate}" pattern="dd/mm/yyyy"/>
                </td>
                <td>${item.position}</td>
                <td>
                    <a type="button" class="btn btn-warning" href="/delete-employee?id=${item.id}">Delete</a>
                </td>
                <td>
                    <a type="button" class="btn btn-success" href="/update-employee?id=${item.id}">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a class="<button disabled></button>" href="/add-employee">Add a Employee</a>
    </div>
</div>
<%@ include file="common/footer.jspf" %>
