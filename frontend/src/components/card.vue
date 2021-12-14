<template>
  <vue-card-stack :cards="cards" :stack-width="480" :card-width="280">
  <template v-slot:card="{ card }">
    <div
      style="width: 100%; height: 100%;"
      :style="{ background: card.background }"
    ></div>
  </template>

   <template v-slot:nav="{ onNext, onPrevious }">
    <nav class="nav">
      <b-row align-h="between">
        <b-col cols=1>
          <b-button v-on:click="onPrevious" class="rounded-circle px-2">
            <img src="remove.png" alt="reject" class="icon-reject"/>
          </b-button>
        </b-col>

        <b-col cols=1> 
          <b-button v-on:click="onNext" class="rounded-circle px-2">
            <img src="heart.png" alt="love" class="icon-love"/>
          </b-button>
        </b-col>  
      </b-row>
    </nav>
  </template>
   
</vue-card-stack>
</template>

<script>
import VueCardStack from "vue-card-stack";
export default {
    components: {
    VueCardStack,
  },
  data() {
    return {
      cards: [
        { background: "#00659d" },
        { background: "#00abbc" },
        { background: "#e2c58a" },
        { background: "#fc8890" },
        { background: "#b35d7f" },
      ],
    };
  },
};
</script>

<style>

.icon-reject {
  width:40px;
  height: auto;
}

.icon-love{
  width:40px;
  height:auto;
}
</style>