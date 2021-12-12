<template>
  <div class="cardcontainer list">
  <ul class="cardlist">
    <li class="card current">#1</li>
    <li class="card">#2</li>
    <li class="card">#3</li>
    <li class="card">#4</li>
    <li class="card">#5</li>
    <li class="card">#6</li>
  </ul>
  <button class="but-nope">X</button>
  <button class="but-yay">✔</button>
</div>
</template>

<script>
export default {
  
}

function animatecard(ev) {
  var t = ev.target;
  if (t.className === 'but-nope') {
    t.parentNode.classList.add('nope');
  }
  if (t.className === 'but-yay') {
    t.parentNode.classList.add('yes');
  }
}
document.body.addEventListener('click', animatecard);
function animationdone(ev) {
 
  // get the container
  var origin = ev.target.parentNode;
 
  // remove the appropriate class
  // depending on the animation name
  if (ev.animationName === 'yay') {
    origin.classList.remove('yes');
  }
  if (ev.animationName === 'nope') {
    origin.classList.remove('nope');
  }
 
  // if any of the card events have 
  // ended…
  if (ev.animationName === 'nope' ||
      ev.animationName === 'yay') {
 
  // remove the first card in the element
    origin.querySelector('.current').remove();
 
  // if there are no cards left, do nothing
    if (!origin.querySelector('.card')) {
      // no more cards left - 
      // TODO other functionality
    } else {
 
  // otherwise shift the 'current' class to 
  // the next card 
      origin.querySelector('.card').
        classList.add('current');
    }
  }

}
document.body.addEventListener(
  'animationend', animationdone
);
</script>

<style scoped>


.card {
  width: 200px;
  height: 300px;
  display: block;
  background: rgb(255, 255, 255);
  transform-origin: 50% 99%;
}
.cardcontainer.yes .card {
  animation: yay 0.7s ease-out;
}
.cardcontainer.nope .card {
  animation: nope 0.7s ease-out;
}
.list .card {
  display: none;
}
.list .current {
  display: block;
}

.but-yay {
  background-color: rgb(0, 255, 0);
  border-radius: 100px 100px ;
}

.but-nope {
  background-color: rgb(255, 0, 0);
  border-radius: 100px 100px ;
}
@keyframes nope {
  from {
    transform: rotate(0deg);
    opacity: 1;
  }
  to {
    transform: rotate(-40deg) translateY(-80px);
    opacity: 0;
  }
}
@keyframes yay {
  from {
    transform: rotate(0deg);
    opacity: 1;
  }
  to {
    transform: rotate(40deg) translateY(-80px);
    opacity: 0;
  }
  
  
}
</style>