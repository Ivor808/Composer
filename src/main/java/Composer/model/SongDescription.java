package model;

public class SongDescription {
  protected Double danceability;
  protected Double energy;
  protected Double valence;
  protected Double tempo;
  protected Double loudness;
  protected Double acousticness;
  protected Double instrumentalness;
  protected Double liveness;
  protected Double speechiness;
  protected Double explicit;
  protected Double mode;
  protected Integer duration;
  protected Double popularity;
  protected Integer songId;

  public SongDescription(Double danceability, Double energy, Double valence, Double tempo,
      Double loudness, Double acousticness, Double instrumentalness, Double liveness,
      Double speechiness, Double explicit, Double mode, Integer duration, Double popularity,
      Integer songId) {
    this.danceability = danceability;
    this.energy = energy;
    this.valence = valence;
    this.tempo = tempo;
    this.loudness = loudness;
    this.acousticness = acousticness;
    this.instrumentalness = instrumentalness;
    this.liveness = liveness;
    this.speechiness = speechiness;
    this.explicit = explicit;
    this.mode = mode;
    this.duration = duration;
    this.popularity = popularity;
    this.songId = songId;
  }

  public Double getDanceability() {
    return danceability;
  }

  public void setDanceability(Double danceability) {
    this.danceability = danceability;
  }

  public Double getEnergy() {
    return energy;
  }

  public void setEnergy(Double energy) {
    this.energy = energy;
  }

  public Double getValence() {
    return valence;
  }

  public void setValence(Double valence) {
    this.valence = valence;
  }

  public Double getTempo() {
    return tempo;
  }

  public void setTempo(Double tempo) {
    this.tempo = tempo;
  }

  public Double getLoudness() {
    return loudness;
  }

  public void setLoudness(Double loudness) {
    this.loudness = loudness;
  }

  public Double getAcousticness() {
    return acousticness;
  }

  public void setAcousticness(Double acousticness) {
    this.acousticness = acousticness;
  }

  public Double getInstrumentalness() {
    return instrumentalness;
  }

  public void setInstrumentalness(Double instrumentalness) {
    this.instrumentalness = instrumentalness;
  }

  public Double getLiveness() {
    return liveness;
  }

  public void setLiveness(Double liveness) {
    this.liveness = liveness;
  }

  public Double getSpeechiness() {
    return speechiness;
  }

  public void setSpeechiness(Double speechiness) {
    this.speechiness = speechiness;
  }

  public Double getExplicit() {
    return explicit;
  }

  public void setExplicit(Double explicit) {
    this.explicit = explicit;
  }

  public Double getMode() {
    return mode;
  }

  public void setMode(Double mode) {
    this.mode = mode;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public Double getPopularity() {
    return popularity;
  }

  public void setPopularity(Double popularity) {
    this.popularity = popularity;
  }

  public Integer getSongId() {
    return songId;
  }

  public void setSongId(Integer songId) {
    this.songId = songId;
  }
}
