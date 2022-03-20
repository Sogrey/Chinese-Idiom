<template>
  <div id="app">
    <img src="./assets/logo.png">
    <router-view />
  </div>
</template>

<script>
import { get, post } from './http/http'
export default {
  name: 'App', data() {
    return {
      userId: 666,
      token: '',
    }
  },
  created() {
    var api = 'http://localhost:10111/user/queryAll';

    get(api).then((response) => {
      console.log(response)
    })
  }
}
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
