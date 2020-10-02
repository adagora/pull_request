<template>
  <div id="app">
    <pull-request-monitor msg="Adrian Góra - Pull Request Monitor"/>
  </div>
</template>

<script>
import PullRequestMonitor from './components/PullRequestMonitor.vue'
import './assets/styles/index.css'

export default {
  name: 'App',
  components: {
    PullRequestMonitor
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
