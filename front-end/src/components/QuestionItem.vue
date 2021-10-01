<template>
  <div class="question-item">
    <div class="name" @click="select">
      <div class="name_photo">
        <b-avatar :src="decodeImage(question.askedPhoto)"></b-avatar>
      </div>
      <div class="name_time">
        <h6 class="myname">
          <span> {{ question.askedUser }} </span>
        </h6>
        <div class="time">
          <span>{{ question.time }}</span>
        </div>
      </div>
    </div>

    <div class="question" @click="answerQuestion(question.stringID)">
      <h4>{{ question.questionText }}</h4>
    </div>
  </div>
</template>

<script>
export default {
  name: "QuestionItem",
  props: {
    question: {
      type: Object,
      required: true,
    },
  },
  methods: {
    answerQuestion(id) {
      // remove this emit
      this.$emit("answer", id);
    },
    select() {
      this.$router.push({
        name: "profile",
        params: { userName: this.question.askedUser },
      });
    },
    decodeImage(image){
      return 'data:image/jpeg;base64,' + image;
    },
  },
};
</script>
<style scoped>
.question-item {
  background-color: #fff;
  padding: 20px;
  border-radius: 10px;
  margin: 20px;
}
.question {
  cursor: pointer;
}
.name {
  display: flex;
}
.name .name_photo,
.name .answer {
  margin: 5px;
}
.name .myname {
  margin-top: 6px;
  font-size: 90%;
}
.name_time {
  padding-left: 4px;
}
.name .time {
  font-size: 70%;
  margin-top: -7px;
  color: #b9b9bb;
}
</style>
