<template>
    <div>
      <h1> SOCORRO </h1>
      <label>ME AJUDE: </label> {{this}}
    </div>
</template>
 
<script>
import http from "../http-common";
 
export default {
  name: "equipment-stats",
  data() {
    return {
      stats: []
    };
  },
  methods: {
    /* eslint-disable no-console */
    retrieveStats() {
      http
        .get("/customers")
        .then(response => {
          this.stats = response.data; // JSON are parsed automatically.
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
  }
}
</script>
 
<style>
.list {
  text-align: left;
  max-width: 450px;
  margin: auto;
}
</style>