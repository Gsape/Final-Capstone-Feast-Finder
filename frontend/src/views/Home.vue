<template>
  <div class="home">
    <h1>Feast Finder</h1>
    <test-card id="test-card"/>
  </div>
</template>

<script>
import TestCard from '../components/TestCard.vue';

export default {
  name: "home",
  components: {
    TestCard
  }
  }
  
</script>



<style scoped>
  .logo {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}

#test-card {
  margin: auto;
  width: 233px;
  height: 74px;
  vertical-align:middle;
  align-items: center;
  padding: 10px;
}

</style>
