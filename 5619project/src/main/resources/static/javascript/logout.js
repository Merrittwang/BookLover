function logout() {
    jQuery.ajax({
        method: "POST",
        url:"api/logout",
        success: () => {
            window.localStorage.clear();
            window.location.replace("./login.html");
        },
    });
}
