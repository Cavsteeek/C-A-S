//code to show a button to list all teachers using fetch to call the api
//and display them in a table.
const getTeachers = () => {
    const url = 'http://localhost:8080/api/v1/cas/admin/get-all-users-by-role/TEACHER';
    let xhr = new XMLHttpRequest();
    xhr.open('GET', url);
    xhr.onload = function() {
        if (this.status == 200) {
            var data = JSON.parse(xhr.responseText);
            console.log(data);
            createTableFromData(data);
            } else {
                alert(`Error ${this.status}: ${xhr.statusText}`);
                }
                };
                xhr.send();
                };
                const createTableFromData = (data) => {
                    const container = document.getElementById("table-container");
                    const table = document.createElement("TABLE");
                    const headerRow = document.createElement("TR");
                    Object.keys(data[0]).forEach((key) => {
                        const th = document.createElement("TH");
                        th.appendChild(document.createTextNode(key));
                        headerRow.appendChild(th);
                        });
                        table.appendChild(headerRow);
                        for (let i=0;i<data.length;i++){
                            const row = document.createElement("TR");
                            Object.values(data[i]).forEach((value)=>{
                                const cell = document.createElement("TD");
                                cell.appendChild(document.createTextNode(value))
                                row.appendChild(cell);
                                })
                                table.appendChild(row);
                                }
                                container.appendChild(table);
                                };
                                window.addEventListener("DOMContentLoaded",getTeachers());

