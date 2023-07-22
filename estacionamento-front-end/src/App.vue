<template>
  <nav class="navbar">
    <div class="container-fluid">
      <div>
        <router-link to="/" class="navbar-brand">
          <img src="./assets/parking-icon.svg" alt="">  
          Peter's 
          Parking
        </router-link> 
      </div>
      <router-link to="/" class="navbar-menu">Movimentações</router-link> 
      <router-link to="/" class="navbar-menu">Condutores</router-link> 
      <router-link to="/" class="navbar-menu">Veiculos</router-link> 
      <router-link to="/" class="navbar-menu">Modelos</router-link> 
      <router-link to="/marcas/lista" class="navbar-menu">Marcas</router-link> 
      <router-link to="/">
        <img src="./assets/gear-solid.svg" alt="">
      </router-link>
    </div>
    </nav>
  <router-view/>
</template>

<style lang="scss">

// Variable overrides first
$primary: #900;
$enable-shadows: true;
$prefix: "mo-";

// Then import Bootstrap
@import "../node_modules/bootstrap/scss/bootstrap";

:root {
  --primary-color: whitesmoke;
  --secondary-color: #241f31;
  //--secondary-color: #2c3e50;
  --sucess-color: #198754;
  --warning-color: #ffc107;
  --danger-color: #dc3545;
}

body {
  background: linear-gradient(0deg, rgba(250, 0, 0, 0.54), rgba(255, 174, 0, 0.69)), url(./assets/ParkingLotBackGround.jpeg);
  background-size: 70%;
  background-position-x: center;
  background-repeat: repeat-x;
  background-attachment: fixed;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  color: var(--secondary-color);
}

.navbar {
  background-color: var(--primary-color);
  margin-bottom: 30px;

  a {
    font-weight: bold;
    color: var(--secondary-color);

    &:hover {
    color: var(--secondary-color);
    }
    &.router-link-exact-active {
      color: var(--secondary-color);
    }
  }

  .navbar-menu {
    font-weight: bold;
    color: var(--secondary-color);
    text-decoration-line: none;

    &:hover {
      text-decoration-line: underline;
    }
    &.router-link-exact-active {
      text-decoration-line: underline;
    }
  }
}

.container-fluid {
  --mo-gutter-x: 6rem;
}

.view-table {
  width: 100%;
  border-radius: 30px;
  background-color: rgba(245, 245, 245, 0.5);
}

.view-table thead {
  border-bottom: 1px solid gray;
}

.view-table tbody th{
  border-top: 1px solid gray;
}

.view-table th {
  padding: 10px 30px 10px 30px;
}

.text-color-sucess {
  color: var(--sucess-color);
}

.sucess-button {
  background-color: var(--sucess-color);
  &:hover {
    background-color: #36a06e;
    color: var(--primary-color);
  }
}

.info-button {
  background-color: var(--warning-color);
  &:hover {
    color: var(--primary-color);
  }
}

.danger-button {
  background-color: var(--danger-color);
  &:hover {
    color: var(--primary-color);
  }
}

.text-color-danger {
  color: #dc3545;;
}

.options-box a:first-child{
  margin-right: 7.5px ;
}

.options-box a:last-child{
  margin-left: 7.5px ;
}

.view-table-info {
  padding: 0px 30px 0px 30px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.list-style-type {
  display: list-item;
  list-style-position: inside;
}

.classic-button {
  padding: 10px;
  border-radius: 30px;
  text-decoration-line: none;
  color: var(--secondary-color);
  &:hover {
    cursor: pointer;
  }
}

.view-form {
  padding: 30px;
  font-weight: bold;
}

.view-form label {
  margin-left: 5px;
}

.view-form input {
  border-radius: 30px;
  width: 100%;
}

.change-status-field {
  margin-top: 15px;
}

.status-switch {
  display: flex;
  width: 130px;
  align-items: center;
  justify-content: space-between;
}

.switch-status {
  width: 40px;
  height: 20px;
  background-color: var(--primary-color);
  border: solid 1px var(--secondary-color);
  margin-left: 15px;
  border-radius: 15px;
  display: flex;
  align-items: center;
  cursor: pointer;
}

.switch-status-interruptor {
  width: 15px;
  height: 15px;
  border-radius: 50%;
  background-color: var(--secondary-color);
  margin: 0px 2px 0px 2px;
}

.interruptor-switch-on {
  justify-content: flex-start;
}

.interruptor-switch-off {
  justify-content: flex-end;
}

.form-view-buttons {
  display: flex;
  justify-content: center;
  margin-top: 20px;

  & a:first-child {
    margin-right: 7.5px;
  }
  & a:last-child {
    margin-left: 7.5px;
  }
}

@media (max-width: 1213px) {
  body {
    background-repeat: repeat
  }
}
</style>
