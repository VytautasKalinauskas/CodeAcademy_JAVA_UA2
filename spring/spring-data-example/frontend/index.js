const getStatistics = async () => {
  const statistics = await fetch("http://localhost:8081/statistics");
  return statistics.json();
};

const renderStatisticsTable = async (statistics) => {
  const tableBody = document.getElementById("statistics-table-body");
  statistics.forEach((s) => {
    const tr = document.createElement("tr");
    for (const key in s) {
      const td = document.createElement("td");
      td.innerText = s[key];
      tr.appendChild(td);
    }
    tableBody.appendChild(tr);
  });
};

const getUsers = async () => {
  const params = new URLSearchParams(window.location.search);
  let getUsersURL = new URL("http://localhost:8081/users");
  getUsersURL.searchParams.set("pageNumber", params.get("pageNumber"));
  getUsersURL.searchParams.set("pageSize", params.get("pageSize"));

  const users = await fetch(getUsersURL);
  return users.json();
};

const renderUsersTable = async (users) => {
  const tableBody = document.getElementById("users-table-body");
  users.forEach((s) => {
    const tr = document.createElement("tr");
    for (const key in s) {
      if (key === "userExams") {
        continue;
      }
      const td = document.createElement("td");
      td.innerText = s[key];
      tr.appendChild(td);
    }
    tableBody.appendChild(tr);
  });
};

(async () => {
  //   const statistics = await getStatistics();
  //   renderStatisticsTable(statistics);
  const users = await getUsers();
  renderUsersTable(users);
})();
