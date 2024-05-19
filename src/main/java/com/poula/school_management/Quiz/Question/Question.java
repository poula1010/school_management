package com.poula.school_management.Quiz.Question;

import com.poula.school_management.Quiz.Answer.Answer;
import com.poula.school_management.Quiz.Quiz;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Question {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;
    @NotNull
    @Column(nullable = false)
    protected String questionTitle;
    @NotNull
    @Column(nullable = false)
    protected int marks;
    @ElementCollection(targetClass = String.class,fetch = FetchType.EAGER)
    @CollectionTable(name="question_options",foreignKey = @ForeignKey(
            name = "fk_question_option",
            foreignKeyDefinition = "foreign key (question_id) references Question (id) on delete cascade"))
    protected Set<String> options;

    @NotNull
    @Column(nullable = false)
    protected String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    protected Quiz quiz;

    @OneToMany(mappedBy = "question",fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    protected Set<Answer> answers = new HashSet<>();

    public Question() {
    }

    public Question(String questionTitle, int marks, Set<String> options, String answer,Quiz quiz) {
        this.questionTitle = questionTitle;
        this.marks = marks;
        this.options = options;
        this.answer = answer;
        this.quiz = quiz;
    }

    public Long getId() {
        return id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public Set<String> getOptions() {
        return options;
    }

    public void setOptions(Set<String> options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (!getQuestionTitle().equals(question.getQuestionTitle())) return false;
        return getAnswer().equals(question.getAnswer());
    }

    @Override
    public int hashCode() {
        int result = getQuestionTitle().hashCode();
        result = 31 * result + getAnswer().hashCode();
        return result;
    }

    public static Question createQuestion(QuestionDto questionDto,Quiz quiz){
        Question question = new Question();
        question.setQuestionTitle(questionDto.getTitle());
        question.setAnswer(questionDto.getAnswer());
        question.setOptions(new HashSet<>(questionDto.getOptions()));
        question.setMarks(questionDto.getMarks());
        question.setQuiz(quiz);

        return question;
    }
}
