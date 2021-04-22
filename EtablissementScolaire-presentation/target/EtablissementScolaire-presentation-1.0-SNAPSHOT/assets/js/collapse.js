document.querySelectorAll("*[data-bs-toggle='collapse']").forEach(item => {
    item.addEventListener('click', event => {
        let allCollapses = document.querySelectorAll(".collapse");
        allCollapses.forEach(collapse => {
            collapse.classList.remove("show", "hide");
        });
    })
});
