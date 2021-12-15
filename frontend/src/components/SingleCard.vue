<template>
  <div class="card">
    <h1>Restaurant Name</h1>

    <div v-for="list in $store.state.searchResults" :key="list.businesses">
        
        <div v-for="restaurant in list.businesses" :key="restaurant.name">
            {{ restaurant.name }}
            {{ restaurant.rating }}
            <img :src='restaurant.image_url' alt="" />
        </div>    
            
        </div>
    </div>
    
    
    <!-- <ul>
      <li v-for="list in $store.state.searchResults" :key="list.businesses">
        <p v-for="restaurant in list.businesses" :key="restaurant.name">
          {{ restaurant.name }}
        </p>
      </li>
    </ul> -->

</template>

<script lang="ts">
import Vue from "vue";
export default Vue.extend({
});
</script>



<style scoped>
.card {
  border-radius: 10px;
  width: 300px;
  height: 400px;
  margin: 20px;
}

img {
    height: 100px;
    width: auto;
}
</style>