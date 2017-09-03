def heroList(key):
    import dota2api
    api = dota2api.Initialise(key)
    return api.get_heroes()['heroes'];
