const openSideBarBtn = document.querySelector('#open-btn');
const sideBar = document.querySelector('.sidebar');

const { pathname } = window.location;



function displayCurrentPage() {

    const anchors = [
        {
            pageUri: '/dashboard',
            anchorContent: 'Relatórios'
        },

        {
            pageUri: '/report',
            anchorContent: 'Reportar'
        }
    ];

    anchors.forEach(e => {
        if (!e.pageUri === pathname) return;

        // if ()
    });
}

openSideBarBtn.addEventListener('click', e => {
    sideBar.classList.toggle('open-sidebar');
    openSideBarBtn.classList.toggle('close-navbar');
});