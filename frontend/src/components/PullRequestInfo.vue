<template>
  <tr>
    <td class="border px-4 py-2">{{ status }}</td>
    <td class="border px-4 py-2">{{ login }}</td>
    <td class="border px-4 py-2">{{ age }}</td>
    <td class="border px-4 py-2"><img class="avatar" v-bind:src="avatar" v-bind:alt="login"/></td>
  </tr>
</template>

<script>

export default {
  name: 'pull-request-info',
  props: {
    id: Number,
    age: Number,
    login: String,
    status: String,
    avatar: String
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

.avatar {
  border-radius: 8px;
  width: 50px;
}
</style>
