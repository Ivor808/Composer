package Composer.model;

public class RecommendationList extends SongList{

  protected String listName;
  protected String recommendationListDescription;


  public RecommendationList(int songListId, User userId, String listName, String recommendationListDescription) {
    super(songListId, userId);
    this.listName = listName;
    this.recommendationListDescription = recommendationListDescription;
  }

  public RecommendationList(int songListId) {
    super(songListId);
  }

  public RecommendationList(User userId, String listName, String recommendationListDescription) {
    super(userId);
    this.listName = listName;
    this.recommendationListDescription = recommendationListDescription;
  }

  public String getListName() {
    return listName;
  }

  public void setListName(String listName) {
    this.listName = listName;
  }

  public String getRecommendationListDescription() {
    return recommendationListDescription;
  }

  public void setRecommendationListDescription(String recommendationListDescription) {
    this.recommendationListDescription = recommendationListDescription;
  }
}
