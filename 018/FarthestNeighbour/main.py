import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.cluster import AgglomerativeClustering
from sklearn.neighbors import kneighbors_graph
import time

# But first, some info:
# If it appears to you to be absolutely INSANE that a driver broke the law 1000+ times...
# It's actually real. I'm providing the sources below:
# https://data.world/dave/bmw-telemetry-data
# And that's only one car model, perhaps in the US.
# The SAT data has absolutely nothing to do with reality, but it's fun to laugh at BMW drivers:
# https://data.world/education/california-sat-report-2013-2014

# Reading data
bmw_dataframe = pd.read_csv("bmw.csv", sep=",", usecols= ['Hard Brake','Hard Accel','>70 MPH','>75 MPH','>80 MPH'])
bmw_dataframe.describe()
sat_dataframe = pd.read_csv("SAT Report 2013-2014.csv", sep=",", usecols=['PctGE1500'])
sat_dataframe.describe()

# Filtering data
sat_dataframe = sat_dataframe.drop(sat_dataframe[sat_dataframe.PctGE1500 == 'NA'].index)
sat_dataframe = sat_dataframe.drop(sat_dataframe[sat_dataframe.PctGE1500 == '*'].index)
sat_df = sat_dataframe['PctGE1500'].dropna()

# Preparing SAT data array

sat_arr = sat_df.sample(1000).astype('float64')

# Selecting the driving incidents of BMW drivers
bmw_df = bmw_dataframe[['Hard Brake','Hard Accel','>70 MPH','>75 MPH','>80 MPH']]
temp_bmw_arr = bmw_df.sample(1000)
bmw_arr = np.sum(temp_bmw_arr, axis=1)

# x = BMW incidents, y = SAT score

X = np.stack((bmw_arr, sat_arr), axis=-1)

# Create a graph capturing local connectivity. Larger number of neighbors
# will give more homogeneous clusters to the cost of computation
# time. A very large number of neighbors gives more evenly distributed
# cluster sizes, but may not impose the local manifold structure of
# the data
knn_graph = kneighbors_graph(X, 30, include_self=False)

for connectivity in (None, knn_graph):
    for n_clusters in (30, 3):
        plt.figure(figsize=(6, 6))
        for index, linkage in enumerate(('complete',)):
            plt.subplot(1, 1, index + 1)
            model = AgglomerativeClustering(linkage=linkage,
                                            connectivity=connectivity,
                                            n_clusters=n_clusters)
            t0 = time.time()
            model.fit(X)
            elapsed_time = time.time() - t0
            plt.scatter(X[:, 0], X[:, 1], c=model.labels_,
                        cmap=plt.cm.nipy_spectral)
            plt.title('linkage=%s\n(time %.2fs)\n(n_cluster=%i, connectivity=%r)' % (linkage, elapsed_time,n_clusters,connectivity is not None),
                      fontdict=dict(verticalalignment='top'))
            plt.xlabel("BMW driver number of incidents")
            plt.ylabel("Average SAT score*")


plt.show()
