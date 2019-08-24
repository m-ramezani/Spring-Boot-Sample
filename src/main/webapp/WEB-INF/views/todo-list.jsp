<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <table class="table table-striped">
        <caption>Your todos are</caption>
        <thead>
        <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is It Done?</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="item">
            <tr>
                <td>${item.desc}</td>
                <td>
                    <fmt:formatDate value="${item.targetDate}" pattern="dd/mm/yyyy"/>
                </td>
                <td>${item.done}</td>
                <td>
                    <a type="button" class="btn btn-warning" href="/delete-todo?id=${item.id}">Delete</a>
                </td>
                <td>
                    <a type="button" class="btn btn-success" href="/update-todo?id=${item.id}">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a class="<button disabled></button>" href="/add-todo">Add a Todo</a>
    </div>
</div>
<%@ include file="common/footer.jspf" %>
