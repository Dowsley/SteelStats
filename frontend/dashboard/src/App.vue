<template>
  <div id="app" class="container-fluid">
    <div class="">
      <h1>SteelStats</h1>
      <h3>Protótipo LowFi</h3>
    </div>
    <nav>
        <router-link class="btn btn-primary" to="/equipment">Anual</router-link>
        <router-link class="btn btn-primary" to="#">Mensal</router-link>
        <router-link class="btn btn-primary" to="#">Diario</router-link>
    </nav>
    <br/>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: "app"
};
</script>
 
<style>
.site-info {
  color: blue;
  margin-bottom: 20px;
}
 
.btn-primary {
  margin-right: 5px;
}
 
.container-fluid {
  text-align: center;
}
</style>
