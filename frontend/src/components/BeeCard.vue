<template>
  <div>
    <div v-for="list in $store.state.searchResults" :key="list.businesses">
    <b-card
        v-for="restaurant in list.businesses" :key="restaurant.name"
        title={{ restaurant.name }}
        img-src='restaurant.image_url'
        img-alt="Image"
        img-top
        tag="article"
        style="max-width: 20rem;"
        class="mb-2"
    >
        <b-card-text>
        {{ restaurant.rating }}
        </b-card-text>

        <b-button href="#" variant="primary">Go somewhere</b-button>
    </b-card>
    </div>
</div>
</template>

<script>
export default {

}
</script>

<style>

</style>