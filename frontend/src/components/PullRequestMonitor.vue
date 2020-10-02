<template>
  <div class="hello">
    <h1>{{ msg }}</h1>

    <div class="flex mb-4">
      <div class="w-2/5 bg-gray-500 h-17">
        <label class="text-gray-700 text-sm font-bold" for="owner">
          Owner
        </label>
        <input
            class="shadow border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            id="owner" type="text" placeholder="Owner" v-model="owner">
      </div>
      <div class="w-2/5 bg-gray-400 h-17">
        <label class="text-gray-700 text-sm font-bold" for="repository">
          Repository
        </label>
        <input
            class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:shadow-outline focus:shadow-outline"
            id="repository" placeholder="Repository" v-model="repository">
      </div>
    </div>
    <span>Open pull requests: {{ pullRequests.length }}</span>
    <table class="table-auto">
      <thead>
      <tr>
        <th class="px-4 py-2">Status</th>
        <th class="px-4 py-2">login</th>
        <th class="px-4 py-2">Age (days)</th>
        <th class="px-4 py-2">Avatar</th>
      </tr>
      </thead>
      <tbody>
        <pull-request-info
            v-for="pullRequest in pullRequests"
            v-bind:age="pullRequest.age"
            v-bind:login="pullRequest.authorLogin"
            v-bind:avatar="pullRequest.authorAvatarUrl"
            v-bind:status="pullRequest.state"
            v-bind:id="pullRequest.id"
            v-bind:key="pullRequest.id"
        ></pull-request-info>

      </tbody>
    </table>
    <ol>
      <pull-request-info
          v-for="pullRequest in pullRequests"
          v-bind:age="pullRequest.age"
          v-bind:login="pullRequest.authorLogin"
          v-bind:avatar="pullRequest.authorAvatarUrl"
          v-bind:status="pullRequest.state"
          v-bind:id="pullRequest.id"
          v-bind:key="pullRequest.id"
      ></pull-request-info>
    </ol>

  </div>
</template>

<script>
import axios from 'axios'
import PullRequestInfo from './PullRequestInfo.vue'

export default {
  name: 'pull-request-monitor',
  props: {
    msg: String
  },
  components: {
    PullRequestInfo
  },
  data() {
    return {
      owner: "evannetwork",
      repository: "bmvi-data-run",
      pullRequests: [],
      errors: []
    }
  },
  created() {
    this.getPullRequests();
    this.timer = setInterval(this.getPullRequests, 10000)
  },
  mounted() {
    this.getPullRequests();
  },
  methods: {
    getPullRequests() {
      return axios
          .get(`/pull-requests/${this.owner}/${this.repository}`)
          .then(response => (this.pullRequests = response.data))
          .then(r => console.log("response: " + JSON.stringify(r)));
    },
    cancelAutoUpdate() {
      clearInterval(this.timer)
    }
  },
  beforeDestroy() {
    clearInterval(this.timer)
  }

}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
